package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseOperateLogDao;
import com.loan.service.model.CaseOperateLog;
import com.loan.service.service.CaseOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-19 20:24
 */
@Service
public class CaseOperateLogServiceImpl extends AbstractLoanService<CaseOperateLog> implements CaseOperateLogService {

    @Autowired
    private CaseOperateLogDao caseOperateLogDao;

    @Override
    protected ISingleTableDao<CaseOperateLog> getMyBatisRepository() {
        return caseOperateLogDao;
    }

    @Override
    protected CaseOperateLog constructPkEntity(Long id) {
        return new CaseOperateLog() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseOperateLog caseOperateLog) {
        return caseOperateLog.getLogId();
    }

    @Override
    public List<CaseOperateLog> getLogsByCaseId(Long caseId) {
        return this.queryEntityList(new CaseOperateLog() {{
            setCaseId(caseId);
        }});
    }
}
