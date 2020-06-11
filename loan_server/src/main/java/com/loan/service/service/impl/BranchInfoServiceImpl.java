package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.BranchInfoDao;
import com.loan.service.model.BranchInfo;
import com.loan.service.model.dto.BranchInfoDto;
import com.loan.service.service.BranchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/23 10:59
 */
@Service
public class BranchInfoServiceImpl extends AbstractLoanService<BranchInfo> implements BranchInfoService {

    @Autowired
    private BranchInfoDao branchInfoDao;

    @Override
    protected ISingleTableDao<BranchInfo> getMyBatisRepository() {
        return branchInfoDao;
    }

    @Override
    protected BranchInfo constructPkEntity(Long id) {
        return new BranchInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(BranchInfo branchInfo) {
        return branchInfo.getBankId();
    }

    @Override
    public LoanPageList<BranchInfoDto> getBranchInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.branchInfoDao.countBranchInfoDto(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<BranchInfoDto> list = this.branchInfoDao.listBranchInfoDto(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public void saveSingleBranch(BranchInfoDto branchInfoDto) {
        Date now = new Date();
        if (null == branchInfoDto.getBranchId()) {
            // 新增
            branchInfoDto.setCreateTime(now);
            branchInfoDto.setModifyTime(now);
            this.create(branchInfoDto);
        } else {
            BranchInfo branchInfo = this.getEntityById(branchInfoDto.getBranchId());
            branchInfoDto.setCreateTime(branchInfo.getCreateTime());
            branchInfoDto.setModifyTime(now);
            this.modifyEntityById(branchInfoDto);
        }
    }

    @Override
    public Integer countBranchCases(Long branchId) {
        // TODO 查询银行案子数
        return 0;
    }
}
