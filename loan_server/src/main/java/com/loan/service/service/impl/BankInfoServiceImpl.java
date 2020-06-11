package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.BankInfoDao;
import com.loan.service.model.BankInfo;
import com.loan.service.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoKang
 * @date 2019/4/23 12:58
 */
@Service
public class BankInfoServiceImpl extends AbstractLoanService<BankInfo> implements BankInfoService {

    @Autowired
    private BankInfoDao bankInfoDao;

    @Override
    protected ISingleTableDao<BankInfo> getMyBatisRepository() {
        return bankInfoDao;
    }

    @Override
    protected BankInfo constructPkEntity(Long id) {
        return null;
    }

    @Override
    protected Object getPk(BankInfo bankInfo) {
        return null;
    }

    @Override
    public BankInfo getBankInfoByBankId(String bankId) {
        return bankInfoDao.getOneByPrimaryKey(new BankInfo() {{
            setBankId(bankId);
        }});
    }
}
