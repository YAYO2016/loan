package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseLoanInfoDao;
import com.loan.service.enums.LoanType;
import com.loan.service.model.CaseLoanInfo;
import com.loan.service.service.CaseLoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-06 21:51
 */
@Service
public class CaseLoanInfoServiceImpl extends AbstractLoanService<CaseLoanInfo> implements CaseLoanInfoService {

    @Autowired
    private CaseLoanInfoDao caseLoanInfoDao;

    @Override

    protected ISingleTableDao<CaseLoanInfo> getMyBatisRepository() {
        return caseLoanInfoDao;
    }

    @Override
    protected CaseLoanInfo constructPkEntity(Long id) {
        return new CaseLoanInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseLoanInfo caseLoanInfo) {
        return caseLoanInfo.getCaseId();
    }

    @Override
    public void saveCaseLoanInfo(CaseLoanInfo caseLoanInfo) {
        if (null == caseLoanInfo || null == caseLoanInfo.getCaseId())
            return;

        CaseLoanInfo oldLoanInfo = this.getEntityById(caseLoanInfo.getCaseId());

        caseLoanInfo.setLoanType(oldLoanInfo.getLoanType());
        caseLoanInfo.setLoanSubType(oldLoanInfo.getLoanSubType());
        caseLoanInfo.setCreateTime(oldLoanInfo.getCreateTime());
        caseLoanInfo.setModifyTime(new Date());

        this.clearLoanAmountAndYearByType(caseLoanInfo.getCaseId(), caseLoanInfo.getLoanType());
        if (LoanType.RESERVE.equals(caseLoanInfo.getLoanType())) {
            // 公积金贷款没有商业额度信息
            caseLoanInfo.setCommercialAmount(null);
            caseLoanInfo.setCommercialYear(null);
        }

        if (LoanType.COMMERCIAL.equals(caseLoanInfo.getLoanType())) {
            // 商业贷款没有公积金贷款信息
            caseLoanInfo.setReserveAmount(null);
            caseLoanInfo.setReserveYear(null);
        }

        this.modifyEntityById(caseLoanInfo);
    }

    /**
     * 清除不必要贷款信息
     */
    public void clearLoanAmountAndYearByType(Long caseId, LoanType loanType) {
        if (LoanType.RESERVE.equals(loanType)) {
            // 公积金贷款没有商业额度信息
            this.caseLoanInfoDao.clearCommercialInfoByCaseId(caseId);
        }
        if (LoanType.COMMERCIAL.equals(loanType)) {
            // 公积金贷款没有商业额度信息
            this.caseLoanInfoDao.clearReserveInfoByCaseId(caseId);
        }
    }
}
