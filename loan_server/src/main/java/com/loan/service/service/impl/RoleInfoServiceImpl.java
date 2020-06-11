package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.RoleInfoDao;
import com.loan.service.model.RoleInfo;
import com.loan.service.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoKang
 * @date 2019-04-22 23:25
 */
@Service
public class RoleInfoServiceImpl extends AbstractLoanService<RoleInfo> implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;

    @Override
    protected ISingleTableDao<RoleInfo> getMyBatisRepository() {
        return roleInfoDao;
    }

    @Override
    protected RoleInfo constructPkEntity(Long id) {
        return null;
    }

    @Override
    protected Object getPk(RoleInfo roleInfo) {
        return roleInfo.getRoleId();
    }
}
