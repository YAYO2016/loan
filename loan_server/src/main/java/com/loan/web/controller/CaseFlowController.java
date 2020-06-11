package com.loan.web.controller;

import com.loan.service.enums.CaseOperateResult;
import com.loan.service.enums.CaseOperateType;
import com.loan.service.enums.CaseStatusDict;
import com.loan.service.enums.LoanType;
import com.loan.service.model.CaseBaseInfo;
import com.loan.service.model.CaseLoanInfo;
import com.loan.service.model.CaseOperateLog;
import com.loan.service.model.CaseStaffs;
import com.loan.service.model.dto.CaseCfgInfoDto;
import com.loan.service.model.dto.CaseOperateLogDto;
import com.loan.service.model.dto.LoanBranchDto;
import com.loan.service.service.*;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.flow.ProcessCheckVo;
import com.loan.web.vo.flow.ProcessReformVo;
import com.loan.web.vo.flow.ProcessVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author GuoKang
 * @date 2019-05-16 22:23
 */
@RestController
@RequestMapping("flow")
public class CaseFlowController {

    @Autowired
    private CaseBaseInfoService caseBaseInfoService;
    @Autowired
    private CaseFlowService caseFlowService;
    @Autowired
    private CaseOperateLogService caseOperateLogService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private CaseStaffsService caseStaffsService;
    @Autowired
    private CaseLoanInfoService caseLoanInfoService;

    /**
     * 驱动案子流程
     *
     * @return
     */
    @PostMapping("drivingProcess")
    public JsonData drivingProcess(@RequestBody ProcessVo processVo) {
        if (null == processVo.getCaseId() || null == processVo.getOperateType())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);

        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(processVo.getCaseId());
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        if (!caseFlowService.checkDrivingProcessRights(processVo.getCaseId(), processVo.getOperateType()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子状态异常");

        List<CaseOperateLog> logs = caseOperateLogService.getLogsByCaseId(processVo.getCaseId());

        CaseStaffs caseStaffs = caseStaffsService.getEntityById(processVo.getCaseId());

//        Optional<CaseOperateLog> logOptional = logs.stream().sorted((o1, o2) -> o2.getLogId().compareTo(o1.getLogId()))
//                .filter(o -> o.getOperateType().equals(CaseOperateType.SUBMIT) && o.getOperateResult().equals(CaseOperateResult.PASS))
//                .findFirst();

        CaseStatusDict newCaseStatus = null;
        CaseOperateResult operateResult = CaseOperateResult.PASS;
        switch (processVo.getOperateType()) {
            case SUBMIT:
                if (null == processVo.getNextOperatorId())
                    return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "下一步操作人为空");
                newCaseStatus = CaseStatusDict.STATUS_102;
                caseStaffs.setRiskId(processVo.getNextOperatorId());
                break;
            case CAIWU_CHECK:
                operateResult = processVo.getOperateResult();
                if (CaseOperateResult.PASS.equals(operateResult)) {
                    newCaseStatus = CaseStatusDict.STATUS_105;
                    // 转给外勤人员
                    if (null == processVo.getNextOperatorId())
                        return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "下一步操作人为空");
                    // 记录外勤人员ID
                    caseStaffs.setFieldId(processVo.getNextOperatorId());
                } else {
                    newCaseStatus = CaseStatusDict.STATUS_106;
                    processVo.setNextOperatorId(caseStaffs.getCreateId());
                }
                break;
            case FIELD_RECEVING:
                newCaseStatus = CaseStatusDict.STATUS_107;
                break;
            case FIELD_RECEIVED:
                newCaseStatus = CaseStatusDict.STATUS_108;
                processVo.setNextOperatorId(caseStaffs.getCreateId());
                break;
            case INTERVIEW_APPOINTMENT:
                newCaseStatus = CaseStatusDict.STATUS_109;
                break;
            case BANK_INTERVIEW:
                newCaseStatus = CaseStatusDict.STATUS_110;
                // 转给风控岗，做贷款审批操作
                processVo.setNextOperatorId(caseStaffs.getRiskId());
                break;
            case BANK_CHECK_COMMERCIAL:
                newCaseStatus = CaseStatusDict.STATUS_111;
                break;
            case CHECK_COMMERCIAL_PASS:
                newCaseStatus = CaseStatusDict.STATUS_112;
                // 如果没有公积金贷款 下一步操作人是外勤岗
                CaseLoanInfo caseLoanInfo = this.caseLoanInfoService.getEntityById(processVo.getCaseId());
                if (caseLoanInfo.getLoanType().equals(LoanType.COMMERCIAL)) {
                    processVo.setNextOperatorId(caseStaffs.getFieldId());
                }
                break;
            case BANK_CHECK_RESERVE:
                newCaseStatus = CaseStatusDict.STATUS_113;
                break;
            case CHECK_RESERVE_PASS:
                newCaseStatus = CaseStatusDict.STATUS_114;
                processVo.setNextOperatorId(caseStaffs.getFieldId());
                break;
            case BANK_REFORM:
                newCaseStatus = CaseStatusDict.STATUS_115;
                // 审核不通过，转给签单
                processVo.setNextOperatorId(caseStaffs.getCreateId());
                break;
            case PICK_UP_CASE:
                newCaseStatus = CaseStatusDict.STATUS_116;
                processVo.setNextOperatorId(caseStaffs.getCreateId());
                break;
            case TRANSFER_APPOINTMENT:
                newCaseStatus = CaseStatusDict.STATUS_117;
                break;
            case TRANSFER_MORTGAGE:
                newCaseStatus = CaseStatusDict.STATUS_118;
                break;
            case MORTGAGE_RECEVING:
                newCaseStatus = CaseStatusDict.STATUS_119;
                processVo.setNextOperatorId(caseStaffs.getFieldId());
                break;
            case SEND_OFF_LOANS:
                newCaseStatus = CaseStatusDict.STATUS_120;
                processVo.setNextOperatorId(caseStaffs.getRiskId());
                break;
            case MAKE_LOAN:
                newCaseStatus = CaseStatusDict.STATUS_121;
                processVo.setNextOperatorId(caseStaffs.getFinanceId());
                break;
            case CAIWU_REVIEW:
                newCaseStatus = CaseStatusDict.STATUS_122;
                processVo.setNextOperatorId(caseStaffs.getCreateId());
                break;
            case CUSTOMER_RECEVING:
                newCaseStatus = CaseStatusDict.STATUS_123;
                break;
            case ARCHIVE_CASE:
                newCaseStatus = CaseStatusDict.STATUS_124;
                processVo.setNextOperatorId(-1L); // 表示终结，不再有人操作
                break;
        }

        if (!caseBaseInfo.getCaseStatus().equals(newCaseStatus)) {
            CaseOperateLog operateLog = this.createOperateLog(processVo.getCaseId(),
                    caseBaseInfo.getCaseStatus(),
                    processVo.getOperateType(),
                    operateResult,
                    processVo.getOperateRemark(),
                    LoginInfoHolder.getUserId(),
                    processVo.getNextOperatorId());

            caseFlowService.drivingCaseProcess(caseBaseInfo, newCaseStatus, operateLog, caseStaffs);
        }
        return JsonData.getSucceed();
    }


    /**
     * 驱动案子流程
     * 风控审核
     *
     * @return
     */
    @PostMapping("drivingProcessForCheck")
    public JsonData drivingProcessForCheck(@RequestBody ProcessCheckVo processCheckVo) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(processCheckVo.getCaseId());
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        if (!caseFlowService.checkDrivingProcessRights(processCheckVo.getCaseId(), processCheckVo.getOperateType()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子状态异常");

        CaseStatusDict newCaseStatus = null;
        CaseOperateResult operateResult = CaseOperateResult.NOT_PASS;

        LoanBranchDto loanBranchDto = new LoanBranchDto();

        CaseStaffs caseStaffs = caseStaffsService.getEntityById(processCheckVo.getCaseId());

        switch (processCheckVo.getOperateType()) {
            case FENGKONG_CHECK:
                if (null == processCheckVo.getBranchName()
                        || null == processCheckVo.getManagerName()
                        || null == processCheckVo.getManagerPhone()) {
                    return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
                }
                BeanUtils.copyProperties(processCheckVo, loanBranchDto);
                operateResult = processCheckVo.getOperateResult();
                if (CaseOperateResult.PASS.equals(operateResult)) {
                    if (null == processCheckVo.getNextOperatorId())
                        return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "下一步操作人为空");
                    newCaseStatus = CaseStatusDict.STATUS_103;
                    caseStaffs.setFinanceId(processCheckVo.getNextOperatorId());
                } else {
                    newCaseStatus = CaseStatusDict.STATUS_104;
                    processCheckVo.setNextOperatorId(caseBaseInfo.getCreateUser());
                }
                break;
        }

        if (!caseBaseInfo.getCaseStatus().equals(newCaseStatus)) {
            CaseOperateLog operateLog = this.createOperateLog(processCheckVo.getCaseId(),
                    caseBaseInfo.getCaseStatus(),
                    processCheckVo.getOperateType(),
                    operateResult,
                    processCheckVo.getOperateRemark(),
                    LoginInfoHolder.getUserId(),
                    processCheckVo.getNextOperatorId());

            caseFlowService.drivingCaseProcessForCheck(caseBaseInfo, newCaseStatus, operateLog, loanBranchDto, caseStaffs);
        }
        return JsonData.getSucceed();
    }


    /**
     * 驱动案子流程
     * 整改
     *
     * @return
     */
    @PostMapping("drivingProcessForReform")
    public JsonData drivingProcessForReform(@RequestBody ProcessReformVo processReformVo) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(processReformVo.getCaseId());
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        if (!caseFlowService.checkDrivingProcessRights(processReformVo.getCaseId(), processReformVo.getOperateType()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子状态异常");

        CaseStatusDict newCaseStatus = null;
        CaseOperateResult operateResult = CaseOperateResult.PASS;

        Long nextOperatorId = null;

        List<CaseOperateLog> logs = caseOperateLogService.getLogsByCaseId(processReformVo.getCaseId());
        Optional<CaseOperateLog> logOptional = Optional.empty();
        switch (processReformVo.getOperateType()) {
            case FENGKONG_REFORM:
            case BANK_REFORM:
                newCaseStatus = CaseStatusDict.STATUS_102;
                // 查询上次提交风控审核时的下一步操作人
                logOptional = logs.stream().sorted((o1, o2) -> o2.getLogId().compareTo(o1.getLogId()))
                        .filter(o -> o.getOperateType().equals(CaseOperateType.SUBMIT) && o.getOperateResult().equals(CaseOperateResult.PASS))
                        .findFirst();
                break;
            case CAIWU_REFORM:
                newCaseStatus = CaseStatusDict.STATUS_103;
                // 查询上次风控审核通过时的下一步操作人
                logOptional = logs.stream().sorted((o1, o2) -> o2.getLogId().compareTo(o1.getLogId()))
                        .filter(o -> o.getOperateType().equals(CaseOperateType.FENGKONG_CHECK) && o.getOperateResult().equals(CaseOperateResult.PASS))
                        .findFirst();
                break;
        }

        if (logOptional.isPresent()) {
            nextOperatorId = logOptional.get().getNextOperatorId();
        }

        if (!caseBaseInfo.getCaseStatus().equals(newCaseStatus)) {
            CaseOperateLog operateLog = this.createOperateLog(processReformVo.getCaseId(),
                    caseBaseInfo.getCaseStatus(),
                    processReformVo.getOperateType(),
                    operateResult,
                    null,
                    LoginInfoHolder.getUserId(),
                    nextOperatorId);

            CaseCfgInfoDto caseCfgInfoDto = new CaseCfgInfoDto();
            caseCfgInfoDto.setCaseId(processReformVo.getCaseId());
            caseCfgInfoDto.setMaterialInfo(processReformVo.getMaterialInfo());
            caseCfgInfoDto.setFeeItemInfo(processReformVo.getFeeItemInfo());

            caseFlowService.drivingCaseProcessForReform(caseBaseInfo, newCaseStatus, operateLog, processReformVo.getLoanInfo(), caseCfgInfoDto);
        }
        return JsonData.getSucceed();
    }

    private CaseOperateLog createOperateLog(Long caseId,
                                            CaseStatusDict statusDict,
                                            CaseOperateType operateType,
                                            CaseOperateResult operateResult,
                                            String operateRemark,
                                            Long operatorId,
                                            Long nextOperatorId) {
        CaseOperateLog caseOperateLog = new CaseOperateLog();
        caseOperateLog.setCaseId(caseId);
        caseOperateLog.setCaseStatus(statusDict);
        caseOperateLog.setOperateType(operateType);
        caseOperateLog.setOperateResult(operateResult);
        caseOperateLog.setOperateRemark(operateRemark);
        caseOperateLog.setOperatorId(operatorId);
        caseOperateLog.setNextOperatorId(null == nextOperatorId ? operatorId : nextOperatorId);
        return caseOperateLog;
    }

    /**
     * 根据案子ID，获取案子流程
     */
    @GetMapping("getCaseFlowList")
    public JsonData getCaseFlowList(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        List<CaseOperateLog> logList = caseOperateLogService.getLogsByCaseId(caseId);
        List<CaseOperateLogDto> logDtoList = new ArrayList<>();
        logList.stream().sorted(Comparator.comparing(CaseOperateLog::getOperateTime).reversed()) // 按照时间正序
                .forEach(log -> {
                    CaseOperateLogDto logDto = new CaseOperateLogDto();
                    BeanUtils.copyProperties(log, logDto);
                    logDto.setOperatorInfo(userInfoService.getUserInfoDtoById(log.getOperatorId()));
                    logDtoList.add(logDto);
                });
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("logs", logDtoList);
        resultMap.put("nextOperator", null);
        logList.stream().max(Comparator.comparing(CaseOperateLog::getOperateTime))
                .filter(log -> log.getNextOperatorId() > 0)
                .ifPresent(log -> resultMap.put("nextOperator", userInfoService.getUserInfoDtoById(log.getNextOperatorId())));
        return JsonData.getSucceed(resultMap);
    }
}