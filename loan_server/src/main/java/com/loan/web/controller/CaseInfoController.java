package com.loan.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.utils.DateUtil;
import com.loan.framework.utils.FeeUtils;
import com.loan.service.enums.*;
import com.loan.service.model.*;
import com.loan.service.model.dto.*;
import com.loan.service.service.*;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.caseinfo.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 案子基本信息
 *
 * @author GuoKang
 * @date 2019/5/6 11:26
 */
@RestController
@RequestMapping("/case")
public class CaseInfoController {

    @Autowired
    private CaseBaseInfoService caseBaseInfoService;
    @Autowired
    private CaseLoanInfoService caseLoanInfoService;
    @Autowired
    private CaseNewHouseInfoService caseNewHouseInfoService;
    @Autowired
    private CaseSecondHandHouseInfoService caseSecondHandHouseInfoService;
    @Autowired
    private CaseCustInfoService caseCustInfoService;
    @Autowired
    private CaseCfgInfoService caseCfgInfoService;
    @Autowired
    private BankInfoService bankInfoService;
    @Autowired
    private CaseOperateLogService caseOperateLogService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ChannelInfoService channelInfoService;

    /**
     * 获取历史案子列表案子列表
     */
    @GetMapping("getAllCaseList")
    public JsonData getAllCaseList(@RequestParam(value = "mainCredit", required = false) String mainCredit,
                                   @RequestParam(value = "seller", required = false) String seller,
                                   @RequestParam(value = "mainCreditCoName", required = false) String mainCreditCoName,
                                   @RequestParam(value = "channelName", required = false) String channelName,
                                   @RequestParam(value = "ifSearchAll", required = false) Boolean ifSearchAll,
                                   @RequestParam(value = "caseType", required = false) CaseType caseType,
                                   @RequestParam(value = "caseSubType", required = false) CaseSubType caseSubType,
                                   @RequestParam(value = "signStartTime", required = false) Date signStartTime,
                                   @RequestParam(value = "signEndTime", required = false) Date signEndTime,
                                   @RequestParam(value = "loanBank", required = false) String loanBank,
                                   @RequestParam(value = "loanBranch", required = false) Long loanBranch,
                                   @RequestParam(value = "occuType", required = false) OccuType occuType,
                                   @RequestParam(value = "orgId", required = false) Long orgId,
                                   @RequestParam(value = "signUser", required = false) Long signUser,
                                   @RequestParam(value = "pageNum") Integer pageNum,
                                   @RequestParam(value = "pageSize") Integer pageSize) {
        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(mainCredit)) params.put("mainCredit", mainCredit);
        if (!StringUtils.isEmpty(seller)) params.put("seller", seller);
        if (!StringUtils.isEmpty(mainCreditCoName)) params.put("mainCreditCoName", mainCreditCoName);
        if (!StringUtils.isEmpty(channelName)) params.put("channelName", channelName);
        if (ifSearchAll) {
            if (null != caseType) params.put("caseType", caseType);
            if (null != caseSubType) params.put("caseSubType", caseSubType);
            if (null != signStartTime) params.put("signStartTime", DateUtil.getStartDate(signStartTime));
            if (null != signEndTime) params.put("signEndTime", DateUtil.getEndDate(signEndTime));
            if (null != loanBranch) params.put("loanBranch", loanBranch);
            if (null != orgId) params.put("orgId", orgId);
            if (null != signUser) params.put("signUser", signUser);
            if (!StringUtils.isEmpty(loanBank)) params.put("loanBank", loanBank);
            if (!StringUtils.isEmpty(occuType)) params.put("occuType", occuType);
        }

        
        LoanPageList<CasePageInfoDto> pageList = caseBaseInfoService.getAllCaseList(params, pageAttr);

        return JsonData.getSucceed(fillTableData(pageList.getDatas()), pageList.getPageInfo());
    }

    
    
    /**
     * 获取历史案子列表案子列表
     */
    @GetMapping("getAllCaseListExport")
    public JsonData getAllCaseListExport(@RequestParam(value = "mainCredit", required = false) String mainCredit,
                                   @RequestParam(value = "seller", required = false) String seller,
                                   @RequestParam(value = "mainCreditCoName", required = false) String mainCreditCoName,
                                   @RequestParam(value = "channelName", required = false) String channelName,
                                   @RequestParam(value = "ifSearchAll", required = false) Boolean ifSearchAll,
                                   @RequestParam(value = "caseType", required = false) CaseType caseType,
                                   @RequestParam(value = "caseSubType", required = false) CaseSubType caseSubType,
                                   @RequestParam(value = "signStartTime", required = false) Date signStartTime,
                                   @RequestParam(value = "signEndTime", required = false) Date signEndTime,
                                   @RequestParam(value = "loanBank", required = false) String loanBank,
                                   @RequestParam(value = "loanBranch", required = false) Long loanBranch,
                                   @RequestParam(value = "occuType", required = false) OccuType occuType,
                                   @RequestParam(value = "orgId", required = false) Long orgId,
                                   @RequestParam(value = "signUser", required = false) Long signUser,
                                   @RequestParam(value = "isExport", required = false) String isExport
                                 	) {
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(mainCredit)) params.put("mainCredit", mainCredit);
        if (!StringUtils.isEmpty(seller)) params.put("seller", seller);
        if (!StringUtils.isEmpty(mainCreditCoName)) params.put("mainCreditCoName", mainCreditCoName);
        if (!StringUtils.isEmpty(channelName)) params.put("channelName", channelName);
        if (ifSearchAll) {
            if (null != caseType) params.put("caseType", caseType);
            if (null != caseSubType) params.put("caseSubType", caseSubType);
            if (null != signStartTime) params.put("signStartTime", DateUtil.getStartDate(signStartTime));
            if (null != signEndTime) params.put("signEndTime", DateUtil.getEndDate(signEndTime));
            if (null != loanBranch) params.put("loanBranch", loanBranch);
            if (null != orgId) params.put("orgId", orgId);
            if (null != signUser) params.put("signUser", signUser);
            if (!StringUtils.isEmpty(loanBank)) params.put("loanBank", loanBank);
            if (!StringUtils.isEmpty(occuType)) params.put("occuType", occuType);
        }

        List<CasePageInfoDto>   exportList = caseBaseInfoService.getAllCaseList(params);
        return JsonData.getSucceed(fillTableData(exportList));
    }
    
    

    private List<CaseInfoPageVo> fillTableData(List<CasePageInfoDto> dataList) {
        List<CaseInfoPageVo> pageVoList = new ArrayList<>();
        dataList.forEach(infoDto -> {
            CaseInfoPageVo pageVo = new CaseInfoPageVo();

            pageVo.setReserveAmount(FeeUtils.getFeeStringNoDecimal(infoDto.getReserveAmount()));
            pageVo.setCommercialAmount(FeeUtils.getFeeStringNoDecimal(infoDto.getCommercialAmount()));

            BeanUtils.copyProperties(infoDto, pageVo);
            // 当前病例的状态
            CaseStatusDict statusDict = infoDto.getCaseStatus();
            // 案子状态描述和环节描述
            pageVo.setCaseStatusDesc(statusDict.getDesc());
            pageVo.setCaseStatusLink(statusDict.getStatusLinkDict().getDesc());

            // 操作按钮
            pageVo.setOperateTypes(CaseOperateType.getCodeDescList(new ArrayList<CaseOperateType>() {{
                add(CaseOperateType.VIEW);
            }}));

            // 持续时间
            pageVo.setLastedDate(DateUtil.calcDateDiffDays(infoDto.getCreateTime(), new Date()));
            pageVoList.add(pageVo);
        });
        return pageVoList;
    }

    /**
     * 案子列表
     * pageType  1:待办任务;2:我发起的;3:我参与的
     * ifClose  1:未完结;2:已完结
     */
    @GetMapping("list")
    public JsonData getWaitCaseList(@RequestParam(value = "pageType") String pageType,
    								@RequestParam(value = "mainCredit", required = false) String mainCredit,
    								@RequestParam(value = "btnType") String btnType,
                                    @RequestParam(value = "ifClose", required = false) String ifClose,
                                    @RequestParam(value = "pageNum") Integer pageNum,
                                    @RequestParam(value = "pageSize") Integer pageSize) {
        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        params.put("userId", LoginInfoHolder.getUserId());
        params.put("pageType", pageType);
        if (!StringUtils.isEmpty(mainCredit)) params.put("mainCredit", mainCredit);
        if (!StringUtils.isEmpty(ifClose)) params.put("ifClose", ifClose);

        if(btnType!=null&&!"".equals(btnType)){
        	params.put("caseStatus",caseBaseInfoService.getCaseStatus(btnType) );
        }
        
        LoanPageList<CaseBaseInfoDto> pageList = this.caseBaseInfoService.getCaseBaseInfoDtoPageList(params, pageAttr);

        //当前用户拥有的角色
        List<RoleDict> roleDictList = RoleDict.getRoleDictByRoleStr(LoginInfoHolder.getUserRoles());

        
        List<CaseInfoPageVo> caseInfoPageVoList = new ArrayList<>();
        Objects.requireNonNull(pageList.getDatas()).forEach(infoDto -> {
            CaseInfoPageVo pageVo = new CaseInfoPageVo();
            BeanUtils.copyProperties(infoDto.getLoanInfo(), pageVo); // 贷款大类
            
            pageVo.setChannelName(infoDto.getChannelName());//品牌名称
            
            UserInfo createUserInfo = userInfoService.getEntityById(infoDto.getCreateUser());
            if (null != createUserInfo) {
                pageVo.setCreateUserName(createUserInfo.getUserName());
            }


            // 公积金贷款金额、商业贷款金额
            pageVo.setReserveAmount(FeeUtils.getFeeStringNoDecimal(infoDto.getLoanInfo().getReserveAmount()));
            pageVo.setCommercialAmount(FeeUtils.getFeeStringNoDecimal(infoDto.getLoanInfo().getCommercialAmount()));

             String [] custNames=new String[1];
             
            
            BeanUtils.copyProperties(infoDto, pageVo); // 案子大类 案子小类 案子状态
            // 主贷人姓名
            Objects.requireNonNull(infoDto.getCustInfos()).forEach(custInfo -> {
                if (CaseCustomerType.BUYER_MAIN_CREDIT.equals(custInfo.getCaseCustType())) {
                	custNames[0]=custInfo.getCustName();
                	pageVo.setMainCredit(custInfo.getCustName());
                }
            });

            if(!StringUtils.isEmpty(mainCredit)&&!mainCredit.equals(custNames[0])){
            	return;
            }
            	
            // 贷款银行
            if (null != infoDto.getLoanInfo() && !StringUtils.isEmpty(infoDto.getLoanInfo().getLoanBank())) {
                BankInfo bankInfo = bankInfoService.getBankInfoByBankId(infoDto.getLoanInfo().getLoanBank());
                pageVo.setLoanBank(null == bankInfo ? null : bankInfo.getBankName());
            }

            // 当前病例的状态
            CaseStatusDict statusDict = infoDto.getCaseStatus();
            // 案子状态描述和环节描述
            pageVo.setCaseStatusDesc(statusDict.getDesc());
            pageVo.setCaseStatusLink(statusDict.getStatusLinkDict().getDesc());

            // 操作按钮
            List<CaseOperateType> operateTypes = new ArrayList<>(statusDict.getStatusOperateTypes());
            Set<CaseOperateType> roleOperateTypes = new HashSet<>();
            if (!CollectionUtils.isEmpty(roleDictList)) {
                if (roleDictList.contains(RoleDict.R0101)) {
                    roleOperateTypes.addAll(RoleDict.R0101.getStatusOperateTypes());
                } else {
                    Objects.requireNonNull(roleDictList).forEach(roleDict -> roleOperateTypes.addAll(roleDict.getStatusOperateTypes()));
                }
                operateTypes.retainAll(roleOperateTypes);

                if (Objects.deepEquals(CaseStatusDict.STATUS_110, statusDict)) {
                    if (LoanType.RESERVE.equals(pageVo.getLoanType())) {
                        operateTypes.remove(CaseOperateType.BANK_CHECK_COMMERCIAL);
                    } else {
                        operateTypes.remove(CaseOperateType.BANK_CHECK_RESERVE);
                    }
                }

                if (Objects.deepEquals(CaseStatusDict.STATUS_112, statusDict)) {
                    if (LoanType.COMMERCIAL.equals(pageVo.getLoanType())) {
                        operateTypes.remove(CaseOperateType.BANK_CHECK_RESERVE);
                    } else {
                        operateTypes.remove(CaseOperateType.PICK_UP_CASE);
                    }
                }
            }

            pageVo.setOperateTypes(CaseOperateType.getCodeDescList(operateTypes));

            // 持续时间
            pageVo.setLastedDate(DateUtil.calcDateDiffDays(infoDto.getCreateTime(), new Date()));

            pageVo.setCreateTime(infoDto.getCreateTime());
            caseInfoPageVoList.add(pageVo);
        });
        
        return JsonData.getSucceed(caseInfoPageVoList, pageList.getPageInfo());
    }

    /**
     * 获取案子总览信息
     */
    @GetMapping("getCaseOverviewInfo")
    public JsonData getCaseOverviewInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseOverviewInfoDto overviewInfoDto = new CaseOverviewInfoDto();
        CaseBaseInfoDto caseBaseInfoDto = caseBaseInfoService.getCaseBaseInfoDtoByCaseId(caseId);
        BeanUtils.copyProperties(caseBaseInfoDto, overviewInfoDto);

        CaseLoanInfoDto caseLoanInfoDto = new CaseLoanInfoDto();
        BeanUtils.copyProperties(caseBaseInfoDto.getLoanInfo(), caseLoanInfoDto);
        caseLoanInfoDto.setLoanBranch(JSONObject.toJavaObject(JSON.parseObject(caseBaseInfoDto.getLoanInfo().getLoanBankBranch()), LoanBranchDto.class));
        overviewInfoDto.setLoanInfo(caseLoanInfoDto);

        overviewInfoDto.setBuyerCustInfo(this.caseCustInfoService.getCustInfoDtoByCaseCustomerType(caseId, CaseCustomerType.BUYER_MAIN_CREDIT));
        overviewInfoDto.setSellerCustInfo(this.caseCustInfoService.getCustInfoDtoByCaseCustomerType(caseId, CaseCustomerType.SELLER_HOUSE_OWNER));

        overviewInfoDto.setCfgInfo(this.caseCfgInfoService.getCaseCfgInfoDto(caseId, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.CHANNEL_INFO);
            add(CaseCfgType.DEVELOPER_INFO);
            add(CaseCfgType.ESTATE_INFO);
            add(CaseCfgType.ESTATE_SALESMAN_INFO);
            add(CaseCfgType.MATERIAL_INFO);
            add(CaseCfgType.FEE_ITEM_INFO);
        }}));

        return JsonData.getSucceed(overviewInfoDto);
    }

    /**
     * 获取案子基本信息
     */
    @GetMapping("getCaseBaseInfo")
    public JsonData getCaseBaseInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseBaseInfoDto caseBaseInfoDto = caseBaseInfoService.getCaseBaseInfoDtoByCaseId(caseId);
        return JsonData.getSucceed(getCaseBaseInfoVoFromDto(caseBaseInfoDto));
    }

    /**
     * 保存案子基本信息
     */
    @PostMapping("saveCaseBaseInfo")
    public JsonData saveCaseBaseInfo(@RequestBody CaseBaseInfoVo caseBaseInfoVo) {
        if (null != caseBaseInfoVo.getCaseId()) {
            CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseBaseInfoVo.getCaseId());
            if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");
        }

        CaseBaseInfoDto caseBaseInfoDto = getCaseBaseInfoDtoFromVo(caseBaseInfoVo);
        if (null != caseBaseInfoDto) {
            caseBaseInfoDto.setCaseVersion(Short.valueOf("1")); // 当前案子流程版本为1。 如果更改流程，改变此值与前值不同
            // 如果没有选渠道专员，又可以新增的人，默认渠道来源是自己
            if (null == caseBaseInfoDto.getBusinessUser()) caseBaseInfoDto.setBusinessUser(new UserInfo() {{
                setUserId(LoginInfoHolder.getUserId());
            }});
            caseBaseInfoDto = caseBaseInfoService.saveCaseBaseInfoDto(LoginInfoHolder.getUserId(), caseBaseInfoDto);
        }
        return JsonData.getSucceed(getCaseBaseInfoVoFromDto(caseBaseInfoDto));
    }

    /**
     * 获取案子贷款信息
     */
    @GetMapping("getCaseLoanInfo")
    public JsonData getCaseLoanInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseLoanInfo caseLoanInfo = this.caseLoanInfoService.getEntityById(caseId);
        CaseLoanInfoVo caseLoanInfoVo = new CaseLoanInfoVo();
        BeanUtils.copyProperties(caseLoanInfo, caseLoanInfoVo);
        return JsonData.getSucceed(caseLoanInfoVo);
    }

    /**
     * 保存案子贷款信息
     */
    @PostMapping("saveCaseLoanInfo")
    public JsonData saveCaseLoanInfo(@RequestBody CaseLoanInfoVo caseLoanInfoVo) {
        if (null == caseLoanInfoVo.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseLoanInfoVo.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseLoanInfo caseLoanInfo = new CaseLoanInfo();
        BeanUtils.copyProperties(caseLoanInfoVo, caseLoanInfo);
        this.caseLoanInfoService.saveCaseLoanInfo(caseLoanInfo);
        return JsonData.getSucceed();
    }

    /**
     * 获取案子一手房抵押物信息
     */
    @GetMapping("getNewHouseCollateralInfo")
    public JsonData getNewHouseCollateralInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseNewHouseInfo caseNewHouseInfo = this.caseNewHouseInfoService.getEntityById(caseId);
        CaseNewHouseInfoVo caseNewHouseInfoVo = new CaseNewHouseInfoVo();
        BeanUtils.copyProperties(caseNewHouseInfo, caseNewHouseInfoVo);
        return JsonData.getSucceed(caseNewHouseInfoVo);
    }

    /**
     * 保存案子一手房抵押物信息
     */
    @PostMapping("saveNewHouseCollateralInfo")
    public JsonData saveNewHouseCollateralInfo(@RequestBody CaseNewHouseInfoVo caseNewHouseInfoVo) {
        if (null == caseNewHouseInfoVo.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseNewHouseInfoVo.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseNewHouseInfo caseNewHouseInfo = new CaseNewHouseInfo();
        BeanUtils.copyProperties(caseNewHouseInfoVo, caseNewHouseInfo);
        this.caseNewHouseInfoService.saveNewHouseInfo(caseNewHouseInfo);
        return JsonData.getSucceed();
    }

    /**
     * 获取案子二手房抵押物信息
     */
    @GetMapping("getSecondHandHouseCollateralInfo")
    public JsonData getSecondHandHouseCollateralInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseSecondHandHouseInfo caseSecondHandHouseInfo = this.caseSecondHandHouseInfoService.getEntityById(caseId);
        CaseSecondHandHouseInfoAddVo secondHandHouseInfoAddVo = new CaseSecondHandHouseInfoAddVo();
        BeanUtils.copyProperties(caseSecondHandHouseInfo, secondHandHouseInfoAddVo);
        return JsonData.getSucceed(secondHandHouseInfoAddVo);
    }

    /**
     * 保存案子二手房抵押物信息
     */
    @PostMapping("saveSecondHandHouseCollateralInfo")
    public JsonData saveNewHouseCollateralInfo(@RequestBody CaseSecondHandHouseInfoAddVo caseNewHouseInfoVo) {
        if (null == caseNewHouseInfoVo.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseNewHouseInfoVo.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseSecondHandHouseInfo caseSecondHandHouseInfo = new CaseSecondHandHouseInfo();
        BeanUtils.copyProperties(caseNewHouseInfoVo, caseSecondHandHouseInfo);
        this.caseSecondHandHouseInfoService.saveCaseSecondHandHouseInfo(caseSecondHandHouseInfo);
        return JsonData.getSucceed();
    }

    /**
     * 获取案子干系人列表
     */
    @GetMapping("getCaseCustInfo")
    public JsonData getCaseCustInfo(@RequestParam("caseId") Long caseId,
                                    @RequestParam("type") CaseCustomerType type) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseCustInfoDto caseCustInfoDto = this.caseCustInfoService.getCustInfoDtoByCaseCustomerType(caseId, type);
        return JsonData.getSucceed(caseCustInfoDto);
    }

    /**
     * 保存案子干系人列表
     */
    @PostMapping("saveCaseCustInfo")
    public JsonData saveCaseCustInfo(@RequestBody CaseCustInfoDto caseCustInfoDto) {
        if (null == caseCustInfoDto.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseCustInfoDto.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        this.caseCustInfoService.saveCaseCustInfo(caseCustInfoDto);
        return JsonData.getSucceed();
    }

    /**
     * 获取案子一手房的开发商、楼盘、销售信息
     */
    @GetMapping("getCaseDeveloperCfgInfo")
    public JsonData getCaseDeveloperCfgInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseCfgInfoDto caseCfgInfoDto = this.caseCfgInfoService.getCaseCfgInfoDto(caseId, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.DEVELOPER_INFO);
            add(CaseCfgType.ESTATE_INFO);
            add(CaseCfgType.ESTATE_SALESMAN_INFO);
        }});
        return JsonData.getSucceed(caseCfgInfoDto);
    }

    /**
     * 保存案子一手房的开发商、楼盘、销售信息
     */
    @PostMapping("saveCaseDeveloperCfgInfo")
    public JsonData saveCaseDeveloperCfgInfo(@RequestBody CaseCfgInfoDto caseCfgInfoDto) {
        if (null == caseCfgInfoDto.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseCfgInfoDto.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        this.caseCfgInfoService.saveCaseCfgInfoDto(caseCfgInfoDto, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.DEVELOPER_INFO);
            add(CaseCfgType.ESTATE_INFO);
            add(CaseCfgType.ESTATE_SALESMAN_INFO);
        }});
        return JsonData.getSucceed();
    }

    /**
     * 获取案子二手房的渠道信息
     */
    @GetMapping("getCaseChannelCfgInfo")
    public JsonData getCaseChannelCfgInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseCfgInfoDto caseCfgInfoDto = this.caseCfgInfoService.getCaseCfgInfoDto(caseId, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.CHANNEL_INFO);
        }});
        return JsonData.getSucceed(caseCfgInfoDto);
    }

    /**
     * 保存案子二手房的渠道信息
     */
    @PostMapping("saveCaseChannelCfgInfo")
    public JsonData saveCaseChannelCfgInfo(@RequestBody CaseCfgInfoDto caseCfgInfoDto) {
        if (null == caseCfgInfoDto.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseCfgInfoDto.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        this.caseCfgInfoService.saveCaseCfgInfoDto(caseCfgInfoDto, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.CHANNEL_INFO);
        }});
        
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("caseId", caseCfgInfoDto.getCaseId());
        param.put("channelId", caseCfgInfoDto.getChannelInfo().get("channelId"));
        channelInfoService.saveCaseRel(param);
        
        return JsonData.getSucceed();
    }

    /**
     * 获取案子的材料信息
     */
    @GetMapping("getCaseMaterialCfgInfo")
    public JsonData getCaseMaterialCfgInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseCfgInfoDto caseCfgInfoDto = this.caseCfgInfoService.getCaseCfgInfoDto(caseId, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.MATERIAL_INFO);
        }});
        return JsonData.getSucceed(caseCfgInfoDto);
    }

    /**
     * 获取案子的材料信息
     */
    @PostMapping("saveCaseMaterialCfgInfo")
    public JsonData saveCaseMaterialCfgInfo(@RequestBody CaseCfgInfoDto caseCfgInfoDto) {
        if (null == caseCfgInfoDto.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseCfgInfoDto.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        this.caseCfgInfoService.saveCaseCfgInfoDto(caseCfgInfoDto, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.MATERIAL_INFO);
        }});
        return JsonData.getSucceed();
    }

    /**
     * 获取案子的费用科目信息
     */
    @GetMapping("getCaseFeeItemCfgInfo")
    public JsonData getCaseFeeItemCfgInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        CaseCfgInfoDto caseCfgInfoDto = this.caseCfgInfoService.getCaseCfgInfoDto(caseId, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.FEE_ITEM_INFO);
        }});
        return JsonData.getSucceed(caseCfgInfoDto);
    }

    /**
     * 整改时获取案子的信息
     */
    @GetMapping("getCaseReformInfo")
    public JsonData getCaseReformInfo(@RequestParam("caseId") Long caseId) {
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseId);
        if (null == caseBaseInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");
        if (!CaseStatusDict.getReformStatusList().contains(caseBaseInfo.getCaseStatus()))
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子状态不正确");

        CaseReformInfoVo reformInfo = new CaseReformInfoVo();
        reformInfo.setCaseId(caseId);
        reformInfo.setCaseType(caseBaseInfo.getCaseType());
        reformInfo.setCaseSubType(caseBaseInfo.getCaseSubType());

        // 放入整改来源
        caseOperateLogService.getLogsByCaseId(caseId)
                .stream()
                .sorted((o1, o2) -> o2.getOperateTime().compareTo(o1.getOperateTime()))
                .findFirst().ifPresent(o -> {
            reformInfo.setReformSource(o.getOperateType().getDesc());
            reformInfo.setReformRemark(o.getOperateRemark());
        });

        reformInfo.setLoanInfo(this.caseLoanInfoService.getEntityById(caseId));
        CaseCfgInfoDto caseCfgInfoDto = caseCfgInfoService.getCaseCfgInfoDto(caseId, Arrays.asList(CaseCfgType.MATERIAL_INFO, CaseCfgType.FEE_ITEM_INFO));

        reformInfo.setMaterialInfo(caseCfgInfoDto.getMaterialInfo());
        reformInfo.setFeeItemInfo(caseCfgInfoDto.getFeeItemInfo());

        return JsonData.getSucceed(reformInfo);
    }

    /**
     * 获取案子的材料信息
     */
    @PostMapping("saveCaseFeeItemCfgInfo")
    public JsonData saveCaseFeeItemCfgInfo(@RequestBody CaseCfgInfoDto caseCfgInfoDto) {
        if (null == caseCfgInfoDto.getCaseId())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "案子ID为空");
        CaseBaseInfo caseBaseInfo = this.caseBaseInfoService.getEntityById(caseCfgInfoDto.getCaseId());
        if (null == caseBaseInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子不存在");

        this.caseCfgInfoService.saveCaseCfgInfoDto(caseCfgInfoDto, new ArrayList<CaseCfgType>() {{
            add(CaseCfgType.FEE_ITEM_INFO);
        }});
        return JsonData.getSucceed();
    }

    private CaseBaseInfoDto getCaseBaseInfoDtoFromVo(CaseBaseInfoVo caseBaseInfoVo) {
        CaseBaseInfoDto caseBaseInfoDto = new CaseBaseInfoDto();
        if (null == caseBaseInfoVo) return null;
        BeanUtils.copyProperties(caseBaseInfoVo, caseBaseInfoDto);
        if (CaseSubType.NEW_HOUSE.equals(caseBaseInfoVo.getCaseSubType())) {
            caseBaseInfoDto.setNewHouseInfo(new CaseNewHouseInfo() {{
                setHouseProperty(caseBaseInfoVo.getHouseProperty());
            }});
            caseBaseInfoDto.setChannelType(null);
        }
        if (CaseSubType.SECOND_HAND_HOUSE.equals(caseBaseInfoVo.getCaseSubType())) {
            caseBaseInfoDto.setSecondHandHouseInfo(new CaseSecondHandHouseInfo() {{
                setHouseProperty(caseBaseInfoVo.getHouseProperty());
                setPropertyRightsType(caseBaseInfoVo.getPropertyRightsType());
                setSuperviseType(caseBaseInfoVo.getSuperviseType());
            }});

            caseBaseInfoDto.setLoanTerms(null);
        }

        caseBaseInfoDto.setLoanInfo(new CaseLoanInfo() {{
            setLoanType(caseBaseInfoVo.getLoanType());
            setLoanSubType(caseBaseInfoVo.getLoanSubType());
        }});

        caseBaseInfoDto.setCustInfos(new ArrayList<CaseCustInfo>() {{
            add(new CaseCustInfo() {{
                setCaseCustType(CaseCustomerType.BUYER_MAIN_CREDIT);
                setMaritalStatus(caseBaseInfoVo.getMaritalStatus());
            }});
        }});

        return caseBaseInfoDto;
    }


    private CaseBaseInfoVo getCaseBaseInfoVoFromDto(CaseBaseInfoDto caseBaseInfoDto) {
        CaseBaseInfoVo caseBaseInfoVo = new CaseBaseInfoVo();
        if (null != caseBaseInfoDto) {
            BeanUtils.copyProperties(caseBaseInfoDto, caseBaseInfoVo);

            if (CaseSubType.NEW_HOUSE.equals(caseBaseInfoVo.getCaseSubType())
                    && null != caseBaseInfoDto.getNewHouseInfo()) {
                // 一手房信息
                caseBaseInfoVo.setHouseProperty(caseBaseInfoDto.getNewHouseInfo().getHouseProperty());
            }
            if (CaseSubType.SECOND_HAND_HOUSE.equals(caseBaseInfoVo.getCaseSubType())
                    && null != caseBaseInfoDto.getSecondHandHouseInfo()) {
                // 二手房信息
                caseBaseInfoVo.setHouseProperty(caseBaseInfoDto.getSecondHandHouseInfo().getHouseProperty());
                caseBaseInfoVo.setPropertyRightsType(caseBaseInfoDto.getSecondHandHouseInfo().getPropertyRightsType());
                caseBaseInfoVo.setSuperviseType(caseBaseInfoDto.getSecondHandHouseInfo().getSuperviseType());
            }

            if (null != caseBaseInfoDto.getLoanInfo()) {
                // 贷款信息
                caseBaseInfoVo.setLoanType(caseBaseInfoDto.getLoanInfo().getLoanType());
                caseBaseInfoVo.setLoanSubType(caseBaseInfoDto.getLoanInfo().getLoanSubType());
            }

            if (!CollectionUtils.isEmpty(caseBaseInfoDto.getCustInfos())) {
                caseBaseInfoDto.getCustInfos().forEach(custInfo -> {
                    if (CaseCustomerType.BUYER_MAIN_CREDIT.equals(custInfo.getCaseCustType()))
                        // 买方主贷人婚姻状况
                        caseBaseInfoVo.setMaritalStatus(custInfo.getMaritalStatus());
                });
            }
        }
        return caseBaseInfoVo;
    }
    
    /**
     * 删除案子
     * @param caseId
     * @return
     */
    @GetMapping("delCase")
    public JsonData  delCase(@RequestParam(value = "caseId") String caseId){
    	try {
    		if(null==caseId){
    			return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "caseId不存在！");
    		}
    		Map<String,Object> params=new HashMap<String, Object>();
    		params.put("caseId", caseId);
    		caseBaseInfoService.delCase(params);
    		return JsonData.getSucceed();
		} catch (Exception e) {
			e.printStackTrace();
			 return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_100, "删除异常！");
		}
    	
    }
    
    /**
     * 查询按钮list
     * @param user_id
     * @return
     */
    @GetMapping("buttonList")
    public JsonData buttonList(@RequestParam(value = "userId") String userId) {
		
    	List<Map<String, Object>>  list=new  ArrayList<Map<String,Object>>();
    	Map<String, Object> params=new HashMap<String, Object>();
    	params.put("userId", userId);
    	//1.根据用户去查询对应的角色
    	List<String> roleList=LoginInfoHolder.getUserRoles();
    	//2.根据不同的角色 取不同的按钮
    	for(String role:roleList){
    		params.put("role", role);
    		list.addAll(caseBaseInfoService.getButtonList(params));
    	}
    	
    	return JsonData.getSucceed(list);
    }


    
    
    
    
}
