package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.DeveloperInfoDao;
import com.loan.service.model.DeveloperInfo;
import com.loan.service.model.dto.DeveloperInfoDto;
import com.loan.service.service.DeveloperInfoService;
import com.loan.service.service.EstateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/26 10:58
 */
@Service
public class DeveloperInfoServiceImpl extends AbstractLoanService<DeveloperInfo> implements DeveloperInfoService {

    @Autowired
    private DeveloperInfoDao developerInfoDao;
    @Autowired
    private EstateInfoService estateInfoService;

    @Override
    protected ISingleTableDao<DeveloperInfo> getMyBatisRepository() {
        return developerInfoDao;
    }

    @Override
    protected DeveloperInfo constructPkEntity(Long id) {
        return new DeveloperInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(DeveloperInfo developerInfo) {
        return developerInfo.getDeveloperId();
    }

    @Override
    public DeveloperInfoDto getDeveloperInfoDto(Long developerId) {
        DeveloperInfoDto developerInfoDto = this.developerInfoDao.getDeveloperInfoDto(developerId);
        developerInfoDto.setEstateInfos(this.estateInfoService.getEstateInfoDto(developerId));
        return developerInfoDto;
    }

    @Override
    @Transactional
    public void saveDeveloperInfoDto(DeveloperInfoDto developerInfoDto) {
        Date now = new Date();
        if (null == developerInfoDto.getDeveloperId()) {
            // 新增
            developerInfoDto.setCreateTime(now);
            developerInfoDto.setModifyTime(now);
            this.create(developerInfoDto);
        } else {
            // 修改
            DeveloperInfo developerInfo = this.getEntityById(developerInfoDto.getDeveloperId());
            developerInfoDto.setCreateUser(developerInfo.getCreateUser());
            developerInfoDto.setCreateTime(developerInfo.getCreateTime());
            developerInfoDto.setModifyTime(now);
            this.modifyEntityById(developerInfoDto);

            // 删除所有楼盘和销售信息
            this.estateInfoService.clearEstateInfo(developerInfoDto.getDeveloperId());
        }

        // 更新楼盘信息
        if (!CollectionUtils.isEmpty(developerInfoDto.getEstateInfos()))
            developerInfoDto.getEstateInfos().forEach(estateInfoDto -> this.estateInfoService.saveEstateInfoDto(developerInfoDto.getDeveloperId(), estateInfoDto));
    }

}
