package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.EstateSalesmanInfoDao;
import com.loan.service.model.EstateSalesmanInfo;
import com.loan.service.service.EstateSalesmanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoKang
 * @date 2019/4/26 10:54
 */
@Service
public class EstateSalesmanInfoServiceImpl extends AbstractLoanService<EstateSalesmanInfo> implements EstateSalesmanInfoService {

    @Autowired
    private EstateSalesmanInfoDao estateSalesmanInfoDao;

    @Override
    protected ISingleTableDao<EstateSalesmanInfo> getMyBatisRepository() {
        return estateSalesmanInfoDao;
    }

    @Override
    protected EstateSalesmanInfo constructPkEntity(Long id) {
        return new EstateSalesmanInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(EstateSalesmanInfo estateSalesmanInfo) {
        return estateSalesmanInfo.getSalesmanId();
    }

    @Override
    public void deleteSalesmanInfoByEstateId(Long estateId) {
        this.estateSalesmanInfoDao.deleteSalesmanInfoByEstateId(estateId);
    }
}
