package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseSecondHandHouseInfoDao;
import com.loan.service.enums.PropertyRightsType;
import com.loan.service.model.CaseSecondHandHouseInfo;
import com.loan.service.service.CaseSecondHandHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author GuoKang
 * @date 2019-05-06 22:35
 */
@Service
public class CaseSecondHandHouseInfoServiceImpl extends AbstractLoanService<CaseSecondHandHouseInfo> implements CaseSecondHandHouseInfoService {

    @Autowired
    private CaseSecondHandHouseInfoDao caseSecondHandHouseInfoDao;

    @Override
    protected ISingleTableDao<CaseSecondHandHouseInfo> getMyBatisRepository() {
        return caseSecondHandHouseInfoDao;
    }

    @Override
    protected CaseSecondHandHouseInfo constructPkEntity(Long id) {
        return new CaseSecondHandHouseInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseSecondHandHouseInfo caseSecondHandHouseInfo) {
        return caseSecondHandHouseInfo.getCaseId();
    }

    @Transactional
    @Override
    public void saveCaseSecondHandHouseInfo(CaseSecondHandHouseInfo caseSecondHandHouseInfo) {
        if (null == caseSecondHandHouseInfo || null == caseSecondHandHouseInfo.getCaseId())
            return;

        CaseSecondHandHouseInfo newHouseInfo = this.getEntityById(caseSecondHandHouseInfo.getCaseId());

        caseSecondHandHouseInfo.setHouseProperty(newHouseInfo.getHouseProperty());
        caseSecondHandHouseInfo.setPropertyRightsType(newHouseInfo.getPropertyRightsType());
        caseSecondHandHouseInfo.setSuperviseType(newHouseInfo.getSuperviseType());
        caseSecondHandHouseInfo.setCreateTime(newHouseInfo.getCreateTime());
        this.modifyEntityById(caseSecondHandHouseInfo);

        this.clearPropertyRightNo(caseSecondHandHouseInfo.getCaseId(), caseSecondHandHouseInfo.getPropertyRightsType());
    }

    @Override
    public void clearPropertyRightNo(Long caseId, PropertyRightsType propertyRightsType) {
        if (PropertyRightsType.HOUSE_CERTIFY.equals(propertyRightsType)) {
            // 清空不动产证
            this.caseSecondHandHouseInfoDao.clearBDCNo(caseId);
        }
        if (PropertyRightsType.REAL_ESTATE.equals(propertyRightsType)) {
            // 清空两证
            this.caseSecondHandHouseInfoDao.clearCQZAndTDZ(caseId);
        }
    }
}
