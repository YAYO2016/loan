package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.EstateInfoDao;
import com.loan.service.model.EstateInfo;
import com.loan.service.model.EstateSalesmanInfo;
import com.loan.service.model.dto.EstateInfoDto;
import com.loan.service.service.DeveloperInfoService;
import com.loan.service.service.EstateInfoService;
import com.loan.service.service.EstateSalesmanInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/26 10:56
 */
@Service
public class EstateInfoServiceImpl extends AbstractLoanService<EstateInfo> implements EstateInfoService {

    @Autowired
    private EstateInfoDao estateInfoDao;
    @Autowired
    private DeveloperInfoService developerInfoService;
    @Autowired
    private EstateSalesmanInfoService estateSalesmanInfoService;

    @Override
    protected ISingleTableDao<EstateInfo> getMyBatisRepository() {
        return estateInfoDao;
    }

    @Override
    protected EstateInfo constructPkEntity(Long id) {
        return new EstateInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(EstateInfo estateInfo) {
        return estateInfo.getEstateId();
    }

    @Override
    public LoanPageList<EstateInfoDto> getDeveloperEstateInfoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.estateInfoDao.countEstateInfoDto(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<EstateInfoDto> list = this.estateInfoDao.listEstateInfoDto(params);

        // 填充开发商信息
        list.forEach(this::fillEstateInfoDtoDeveloperInfo);

        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public List<EstateInfoDto> getEstateInfoDto(Long developerId) {
        EstateInfo estateInfo = new EstateInfo();
        estateInfo.setDeveloperId(developerId);
        List<EstateInfo> estateInfoList = this.queryEntityList(estateInfo);

        if (CollectionUtils.isEmpty(estateInfoList)) return new ArrayList<>();

        List<EstateInfoDto> estateInfoDtoList = new ArrayList<>();

        estateInfoList.forEach(info -> {
            EstateInfoDto estateInfoDto = new EstateInfoDto();
            BeanUtils.copyProperties(info, estateInfoDto);

            estateInfoDto.setSalesmanInfos(this.estateSalesmanInfoService.queryEntityList(new EstateSalesmanInfo() {{
                setEstateId(info.getEstateId());
            }}));

            estateInfoDtoList.add(estateInfoDto);
        });

        return estateInfoDtoList;
    }

    @Override
    @Transactional
    public void saveEstateInfoDto(Long developerId, EstateInfoDto estateInfoDto) {
        Date now = new Date();
        estateInfoDto.setDeveloperId(developerId);
        estateInfoDto.setCreateTime(now);
        this.create(estateInfoDto);

        if (!CollectionUtils.isEmpty(estateInfoDto.getSalesmanInfos())) {
            estateInfoDto.getSalesmanInfos().forEach(info -> {
                if (info.isEmpty())
                    return;
                info.setEstateId(estateInfoDto.getEstateId());
                info.setCreateTime(now);
                this.estateSalesmanInfoService.create(info);
            });
        }
    }

    @Override
    public void clearEstateInfo(Long developerId) {
        // 根据developerId 删除所有楼盘信息
        List<EstateInfo> estateInfoList = this.queryEntityList(new EstateInfo() {{
            setDeveloperId(developerId);
        }});

        if (!CollectionUtils.isEmpty(estateInfoList)) {
            estateInfoList.forEach(estateInfo -> {
                this.deleteEntityById(estateInfo.getEstateId());
                this.estateSalesmanInfoService.deleteSalesmanInfoByEstateId(estateInfo.getEstateId());
            });
        }
    }

    @Override
    @Transactional
    public void deleteEstateInfoById(Long estateId) {
        // 删除销售信息
        this.estateSalesmanInfoService.deleteSalesmanInfoByEstateId(estateId);

        // 删除楼盘信息
        this.deleteEntityById(estateId);

    }

    private void fillEstateInfoDtoDeveloperInfo(EstateInfoDto estateInfoDto) {
        if (null != estateInfoDto.getDeveloperId())
            estateInfoDto.setDeveloperInfo(this.developerInfoService.getEntityById(estateInfoDto.getDeveloperId()));
    }
}
