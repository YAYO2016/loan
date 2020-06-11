package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.FeeItemInfoDao;
import com.loan.service.model.FeeItemInfo;
import com.loan.service.service.FeeItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 16:16
 */
@Service
public class FeeItemInfoServiceImpl extends AbstractLoanService<FeeItemInfo> implements FeeItemInfoService {

    @Autowired
    private FeeItemInfoDao feeItemInfoDao;

    @Override
    protected ISingleTableDao<FeeItemInfo> getMyBatisRepository() {
        return feeItemInfoDao;
    }

    @Override
    protected FeeItemInfo constructPkEntity(Long id) {
        return new FeeItemInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(FeeItemInfo feeItemInfo) {
        return feeItemInfo.getItemId();
    }

    @Override
    public LoanPageList<FeeItemInfo> getFeeItemInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.feeItemInfoDao.countFeeItemInfo(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<FeeItemInfo> list = this.feeItemInfoDao.listFeeItemInfo(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public void saveFeeItemInfo(FeeItemInfo feeItemInfo) {
        Date now = new Date();
        if (null == feeItemInfo.getItemId()) {
            // 新增
            feeItemInfo.setCreateTime(now);
            feeItemInfo.setModifyTime(now);
            this.create(feeItemInfo);
        } else {
            // 修改
            FeeItemInfo oldFeeItemInfo = this.getEntityById(feeItemInfo.getItemId());
            feeItemInfo.setCreateTime(oldFeeItemInfo.getCreateTime());
            feeItemInfo.setModifyTime(now);
            this.modifyEntityById(feeItemInfo);
        }
    }
}
