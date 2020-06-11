package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.MaterialInfoDao;
import com.loan.service.model.MaterialInfo;
import com.loan.service.service.MaterialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/25 11:16
 */
@Service
public class MaterialInfoServiceImpl extends AbstractLoanService<MaterialInfo> implements MaterialInfoService {

    @Autowired
    private MaterialInfoDao materialInfoDao;

    @Override
    protected ISingleTableDao<MaterialInfo> getMyBatisRepository() {
        return materialInfoDao;
    }

    @Override
    protected MaterialInfo constructPkEntity(Long id) {
        return new MaterialInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(MaterialInfo materialInfo) {
        return materialInfo.getMaterialId();
    }

    @Override
    public LoanPageList<MaterialInfo> getMaterialInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.materialInfoDao.countMaterialInfo(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<MaterialInfo> list = this.materialInfoDao.listMaterialInfo(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public void saveSingleMaterial(MaterialInfo materialInfo) {
        Date now = new Date();
        if (null == materialInfo.getMaterialId()) {
            // 新增
            materialInfo.setCreateTime(now);
            materialInfo.setModifyTime(now);
            this.create(materialInfo);
        } else {
            // 修改
            MaterialInfo oldMaterialInfo = this.getEntityById(materialInfo.getMaterialId());
            materialInfo.setCreateUser(oldMaterialInfo.getCreateUser());
            materialInfo.setCreateTime(oldMaterialInfo.getCreateTime());
            materialInfo.setModifyTime(now);
            this.modifyEntityById(materialInfo);
        }
    }
}
