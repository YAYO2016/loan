package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseStaffsDao;
import com.loan.service.model.CaseOperateLog;
import com.loan.service.model.CaseStaffs;
import com.loan.service.service.CaseOperateLogService;
import com.loan.service.service.CaseStaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author GuoKang
 * @date 2019/8/5 15:59
 */
@Service
public class CaseStaffsServiceImpl extends AbstractLoanService<CaseStaffs> implements CaseStaffsService {

    @Autowired
    private CaseStaffsDao caseStaffsDao;

    @Override
    protected ISingleTableDao<CaseStaffs> getMyBatisRepository() {
        return this.caseStaffsDao;
    }

    @Override
    protected CaseStaffs constructPkEntity(Long id) {
        return new CaseStaffs() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseStaffs caseStaffs) {
        return caseStaffs.getCaseId();
    }

    @Override
    @Transactional
    public void createOrUpdateCaseStaffsInfo(CaseStaffs caseStaffs) {
        if (null == caseStaffs || null == caseStaffs.getCaseId()) return;
        // 先查询当前有没有，如果有就删除
        this.deleteEntityById(caseStaffs.getCaseId());
        caseStaffsDao.insert(caseStaffs);
    }
}
