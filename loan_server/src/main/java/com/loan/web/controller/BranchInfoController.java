package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.model.BankInfo;
import com.loan.service.model.BranchInfo;
import com.loan.service.model.CaseBaseInfo;
import com.loan.service.model.CaseLoanInfo;
import com.loan.service.model.dto.BranchInfoDto;
import com.loan.service.service.BankInfoService;
import com.loan.service.service.BranchInfoService;
import com.loan.service.service.CaseLoanInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.vo.bank.BranchCaseCheckVo;
import com.loan.web.vo.bank.BranchInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 11:13
 */
@RestController
@RequestMapping("/branch")
public class BranchInfoController {

    @Autowired
    private BranchInfoService branchInfoService;
    @Autowired
    private CaseLoanInfoService caseLoanInfoService;
    @Autowired
    private BankInfoService bankInfoService;

    @GetMapping("list")
    public JsonData list(@RequestParam(value = "bankId", required = false) String bankId,
                         @RequestParam(value = "branchName", required = false) String branchName,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(branchName)) params.put("branchName", branchName);
        if (!StringUtils.isEmpty(bankId)) params.put("bankId", bankId);

        LoanPageList<BranchInfoDto> branchInfoPageList = this.branchInfoService.getBranchInfoPageList(params, pageAttr);

        // 查询银行的案子数
        if (!CollectionUtils.isEmpty(branchInfoPageList.getDatas())) {
            branchInfoPageList.getDatas().forEach(branchInfoDto -> branchInfoDto.setCaseCount(this.branchInfoService.countBranchCases(branchInfoDto.getBranchId())));
        }
        return JsonData.getSucceed(branchInfoPageList.getDatas(), branchInfoPageList.getPageInfo());
    }

    @GetMapping("getSingleBranch")
    public JsonData getSingleBranch(@RequestParam(value = "branchId") Long branchId) {
        BranchInfo branchInfo = this.branchInfoService.getEntityById(branchId);
        if (null == branchInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "银行信息不存在");

        BranchInfoVo branchInfoVo = new BranchInfoVo();
        BeanUtils.copyProperties(branchInfo, branchInfoVo);
        return JsonData.getSucceed(branchInfoVo);
    }

    @PostMapping("addOrUpdateSingleBranch")
    public JsonData addOrUpdateSingleBranch(@RequestBody BranchInfoVo branchInfoVo) {
        if (null != branchInfoVo.getBranchId()) {
            BranchInfo branchInfo = this.branchInfoService.getEntityById(branchInfoVo.getBranchId());
            if (null == branchInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "银行信息不存在");
        }

        BranchInfoDto branchInfoDto = new BranchInfoDto();
        BeanUtils.copyProperties(branchInfoVo, branchInfoDto);
        this.branchInfoService.saveSingleBranch(branchInfoDto);
        return JsonData.getSucceed();
    }

    @PostMapping("deleteBranch")
    public JsonData deleteBranch(@RequestBody BranchInfoVo branchInfoVo) {
        if (null == branchInfoVo.getBranchId()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
        BranchInfo branchInfo = this.branchInfoService.getEntityById(branchInfoVo.getBranchId());
        if (null == branchInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "银行信息不存在");

//        if (this.branchInfoService.countBranchCases(branchInfo.getBranchId()) > 0)
//            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "银行已有案子，不允许删除");

        this.branchInfoService.deleteEntityById(branchInfo.getBranchId());
        return JsonData.getSucceed();
    }

    /**
     * 用于风控审核弹窗
     */
    @GetMapping("getBranchInfo")
    public JsonData getBranchInfo(@RequestParam("caseId") Long caseId) {
        CaseLoanInfo caseLoanInfo = caseLoanInfoService.getEntityById(caseId);
        if (null == caseLoanInfo || null == caseLoanInfo.getLoanBank())
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "案子贷款信息不完整");

        List<BranchInfo> branchList = this.branchInfoService.queryEntityList(new BranchInfo() {{
            setBankId(caseLoanInfo.getLoanBank());
        }});

        BankInfo bankInfo = this.bankInfoService.getBankInfoByBankId(caseLoanInfo.getLoanBank());

        BranchCaseCheckVo branchCaseCheckVo = new BranchCaseCheckVo();
        branchCaseCheckVo.setCaseId(caseId);
        branchCaseCheckVo.setBankName(bankInfo.getBankName());
        branchCaseCheckVo.setBranchInfos(branchList);

        return JsonData.getSucceed(branchCaseCheckVo);
    }
}
