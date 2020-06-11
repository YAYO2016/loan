package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.model.CaseOperateLog;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-19 20:24
 */
public interface CaseOperateLogService extends LoanService<CaseOperateLog> {
    List<CaseOperateLog> getLogsByCaseId(Long caseId);
}
