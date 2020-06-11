package com.loan.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.loan.service.enums.CaseCfgType;
import com.loan.service.enums.CaseOperateType;
import com.loan.service.enums.CaseStatusDict;
import com.loan.service.enums.LoanType;
import com.loan.service.model.*;
import com.loan.service.model.dto.CaseCfgInfoDto;
import com.loan.service.model.dto.LoanBranchDto;
import com.loan.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-19 20:27
 */
@Service
public class CaseFlowServiceImpl implements CaseFlowService {
    @Autowired
    private CaseBaseInfoService caseBaseInfoService;
    @Autowired
    private CaseOperateLogService caseOperateLogService;
    @Autowired
    private CaseLoanInfoService caseLoanInfoService;
    @Autowired
    private CaseCfgInfoService caseCfgInfoService;
    @Autowired
    private CaseStaffsService caseStaffsService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserInfoService userInfoService;

    @Transactional
    @Override
    public void drivingCaseProcess(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog, CaseStaffs caseStaffs) {
        updateCaseStatus(caseBaseInfo, newCaseStatus, operateLog);
        caseStaffsService.modifyEntityById(caseStaffs);
    }

    @Transactional
    @Override
    public void drivingCaseProcessForCheck(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog, LoanBranchDto loanBranchDto, CaseStaffs caseStaffs) {
        updateCaseStatus(caseBaseInfo, newCaseStatus, operateLog);
        caseStaffsService.modifyEntityById(caseStaffs);
        // 更新贷款信息
        CaseLoanInfo caseLoanInfo = caseLoanInfoService.getEntityById(caseBaseInfo.getCaseId());
        caseLoanInfo.setLoanBankBranch(JSON.toJSONString(loanBranchDto));
        caseLoanInfoService.modifyEntityById(caseLoanInfo);
    }

    /**
     * 更新案子状态等
     */
    @Transactional
    public void updateCaseStatus(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog) {
        Date now = new Date();
        // 更新案子状态码
        caseBaseInfo.setCaseStatus(newCaseStatus);
        caseBaseInfo.setModifyTime(now);
        this.caseBaseInfoService.modifyEntityById(caseBaseInfo);

        // 保存操作记录
        operateLog.setOperateTime(now);
        caseOperateLogService.create(operateLog);

        // 当前操作人与下一步操作人不是同一个人时，发消息给下一步操作人
        if (operateLog.getNextOperatorId() > 0
                && !operateLog.getOperatorId().equals(operateLog.getNextOperatorId())) {
            UserInfo userInfo = userInfoService.getEntityById(operateLog.getNextOperatorId());
            messageService.sendMessageNotifyBySocket(userInfo.getLoginAccount(), "");
        }
    }

    @Override
    public Boolean checkDrivingProcessRights(Long caseId, CaseOperateType operateType) {
        CaseBaseInfo caseBaseInfo = caseBaseInfoService.getEntityById(caseId);
        return caseBaseInfo.getCaseStatus().getStatusOperateTypes().contains(operateType);
    }

    @Transactional
    @Override
    public void drivingCaseProcessForReform(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog, CaseLoanInfo loanInfo, CaseCfgInfoDto caseCfgInfoDto) {
        updateCaseStatus(caseBaseInfo, newCaseStatus, operateLog);

        CaseLoanInfo caseLoanInfo = this.caseLoanInfoService.getEntityById(caseBaseInfo.getCaseId());
        caseLoanInfo.setLoanType(loanInfo.getLoanType());
        caseLoanInfo.setRepaymentType(loanInfo.getRepaymentType());
        caseLoanInfo.setRepaymentAccount(loanInfo.getRepaymentAccount());
        caseLoanInfo.setLoanBank(loanInfo.getLoanBank());
        this.caseLoanInfoService.clearLoanAmountAndYearByType(caseLoanInfo.getCaseId(), caseLoanInfo.getLoanType());
        caseLoanInfo.setReserveAmount(null);
        caseLoanInfo.setReserveYear(null);
        caseLoanInfo.setCommercialAmount(null);
        caseLoanInfo.setCommercialYear(null);
        if (!LoanType.COMMERCIAL.equals(loanInfo.getLoanType())) {
            caseLoanInfo.setReserveAmount(loanInfo.getReserveAmount());
            caseLoanInfo.setReserveYear(loanInfo.getReserveYear());
        }
        if (!LoanType.RESERVE.equals(loanInfo.getLoanType())) {
            caseLoanInfo.setCommercialAmount(loanInfo.getCommercialAmount());
            caseLoanInfo.setCommercialYear(loanInfo.getCommercialYear());
        }
        caseLoanInfo.setModifyTime(new Date());
        this.caseLoanInfoService.modifyEntityById(caseLoanInfo);


        caseCfgInfoDto.setCaseId(caseBaseInfo.getCaseId());
        caseCfgInfoService.saveCaseCfgInfoDto(caseCfgInfoDto, Arrays.asList(CaseCfgType.MATERIAL_INFO, CaseCfgType.FEE_ITEM_INFO));
    }

}
