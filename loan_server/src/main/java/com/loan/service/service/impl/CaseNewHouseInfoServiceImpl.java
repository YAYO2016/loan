package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseNewHouseInfoDao;
import com.loan.service.enums.LoanType;
import com.loan.service.model.CaseLoanInfo;
import com.loan.service.model.CaseNewHouseInfo;
import com.loan.service.service.CaseNewHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-06 22:18
 */
@Service
public class CaseNewHouseInfoServiceImpl extends AbstractLoanService<CaseNewHouseInfo> implements CaseNewHouseInfoService {

    @Autowired
    private CaseNewHouseInfoDao caseNewHouseInfoDao;

    @Override
    protected ISingleTableDao<CaseNewHouseInfo> getMyBatisRepository() {
        return caseNewHouseInfoDao;
    }

    @Override
    protected CaseNewHouseInfo constructPkEntity(Long id) {
        return new CaseNewHouseInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseNewHouseInfo caseNewHouseInfo) {
        return caseNewHouseInfo.getCaseId();
    }

    @Override
    public void saveNewHouseInfo(CaseNewHouseInfo caseNewHouseInfo) {
        if (null == caseNewHouseInfo || null == caseNewHouseInfo.getCaseId())
            return;

        CaseNewHouseInfo newHouseInfo = this.getEntityById(caseNewHouseInfo.getCaseId());
        caseNewHouseInfo.setHouseProperty(newHouseInfo.getHouseProperty());
        caseNewHouseInfo.setCreateTime(newHouseInfo.getCreateTime());

        this.modifyEntityById(caseNewHouseInfo);
    }
}
