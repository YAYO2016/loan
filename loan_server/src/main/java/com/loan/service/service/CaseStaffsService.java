package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.CaseStaffs;

/**
 * @author GuoKang
 * @date 2019/8/5 15:59
 */
public interface CaseStaffsService extends LoanService<CaseStaffs> {
    void createOrUpdateCaseStaffsInfo(CaseStaffs caseStaffs);
}
