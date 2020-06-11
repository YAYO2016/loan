package com.loan.service.service;

import com.loan.service.enums.CaseOperateType;
import com.loan.service.enums.CaseStatusDict;
import com.loan.service.model.CaseBaseInfo;
import com.loan.service.model.CaseLoanInfo;
import com.loan.service.model.CaseOperateLog;
import com.loan.service.model.CaseStaffs;
import com.loan.service.model.dto.CaseCfgInfoDto;
import com.loan.service.model.dto.LoanBranchDto;

/**
 * @author GuoKang
 * @date 2019-05-19 20:27
 */
public interface CaseFlowService {

    void drivingCaseProcess(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog, CaseStaffs caseStaffs);

    void drivingCaseProcessForCheck(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog, LoanBranchDto loanBranchDto, CaseStaffs caseStaffs);

    /**
     * 检测案子与操作的合法性
     *
     * @return true 允许操作
     */
    Boolean checkDrivingProcessRights(Long caseId, CaseOperateType operateType);

    void drivingCaseProcessForReform(CaseBaseInfo caseBaseInfo, CaseStatusDict newCaseStatus, CaseOperateLog operateLog, CaseLoanInfo loanInfo, CaseCfgInfoDto caseCfgInfoDto);
}
