package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.OrganizationInfoDao;
import com.loan.service.model.OrganizationInfo;
import com.loan.service.model.UserInfo;
import com.loan.service.model.dto.OrganizationInfoDto;
import com.loan.service.model.dto.UserInfoDto;
import com.loan.service.service.OrganizationInfoService;
import com.loan.service.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-21 20:49
 */
@Service
public class OrganizationInfoServiceImpl extends AbstractLoanService<OrganizationInfo> implements OrganizationInfoService {
    Logger logger = LoggerFactory.getLogger(OrganizationInfoServiceImpl.class);

    @Autowired
    private OrganizationInfoDao organizationInfoDao;
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected ISingleTableDao<OrganizationInfo> getMyBatisRepository() {
        return organizationInfoDao;
    }

    @Override
    protected OrganizationInfo constructPkEntity(Long id) {
        return new OrganizationInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(OrganizationInfo organizationInfo) {
        return organizationInfo.getOrgId();
    }

    @Override
    public LoanPageList<OrganizationInfoDto> getOrganizationInfoLoanPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.organizationInfoDao.countOrganizationInfo(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<OrganizationInfoDto> list = this.organizationInfoDao.listOrganizationInfo(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public Integer countOrgUsers(Long orgId) {
        // 查询组织机构下的用户数量
        UserInfo userInfo = new UserInfo();
        userInfo.setOrgId(orgId);
        List<UserInfo> userInfoList = this.userInfoService.queryEntityList(userInfo);
        return CollectionUtils.isEmpty(userInfoList) ? 0 : userInfoList.size();
    }

    @Override
    public OrganizationInfoDto getOrganizationInfoDtoById(Long orgId) {
        return this.organizationInfoDao.getOrganizationInfoDtoById(orgId);
    }

    @Override
    @Transactional
    public void saveSingleOrganization(OrganizationInfoDto organizationInfoDto, List<UserInfoDto> userInfoDtoList) {
        Date now = new Date();
        // 保存组织架构信息，有就更新，没有就新增
        if (null != organizationInfoDto.getOrgId()) {
            OrganizationInfo orgInfo = this.getEntityById(organizationInfoDto.getOrgId());
            organizationInfoDto.setCreateTime(orgInfo.getCreateTime());
            organizationInfoDto.setModifyTime(now);
            this.modifyEntityById(organizationInfoDto);
        } else {
            organizationInfoDto.setCreateTime(now);
            organizationInfoDto.setModifyTime(now);
            this.create(organizationInfoDto);
        }

        // 更新用户表中组织机构信息
        // 清除用户表中，当前组织架构ID的所有用户
        this.userInfoService.clearUserOrgInfo(organizationInfoDto.getOrgId());

        userInfoDtoList.forEach(dto -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(dto.getUserId());
            userInfo.setOrgId(organizationInfoDto.getOrgId());
            this.userInfoService.modifyEntityById(userInfo);
        });
    }
}
