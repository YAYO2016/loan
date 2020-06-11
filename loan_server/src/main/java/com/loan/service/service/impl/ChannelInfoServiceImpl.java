package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.ChannelInfoDao;
import com.loan.service.model.ChannelInfo;
import com.loan.service.model.ChannelStaffInfo;
import com.loan.service.model.dto.ChannelInfoDto;
import com.loan.service.service.ChannelInfoService;
import com.loan.service.service.ChannelStaffService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-19 00:40
 */
@Service
public class ChannelInfoServiceImpl extends AbstractLoanService<ChannelInfo> implements ChannelInfoService {
    @Autowired
    private ChannelInfoDao channelInfoDao;
    @Autowired
    private ChannelStaffService channelStaffService;

    @Override
    protected ISingleTableDao<ChannelInfo> getMyBatisRepository() {
        return channelInfoDao;
    }

    @Override
    protected ChannelInfo constructPkEntity(Long id) {
        return new ChannelInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(ChannelInfo agencyInfo) {
        return agencyInfo.getChannelId();
    }

    @Override
    public LoanPageList<ChannelInfo> getChannelInfoLoanPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());

        int count = this.channelInfoDao.countChannelInfo(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<ChannelInfo> list = this.channelInfoDao.listChannelInfo(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public Integer countChannelCases(Long channelId) {
        // TODO 获取渠道的案子数
        return 0;
    }

    @Override
    public ChannelInfoDto getChannelInfoDtoById(Long channelId) {
        ChannelInfoDto channelInfoDto = new ChannelInfoDto();
        ChannelInfo channelInfo = this.getEntityById(channelId);
        if (null == channelInfo) return null;
        BeanUtils.copyProperties(channelInfo, channelInfoDto);

        List<ChannelStaffInfo> staffInfos = this.channelStaffService.queryEntityList(new ChannelStaffInfo() {{
            setChannelId(channelId);
        }});

        if (CollectionUtils.isEmpty(staffInfos)) {
            channelInfoDto.setStaffInfos(new ArrayList<>());
        } else {
            channelInfoDto.setStaffInfos(staffInfos);
        }

        return channelInfoDto;
    }

    @Override
    @Transactional
    public void saveSingleChannel(ChannelInfoDto channelInfoDto) {
        Date now = new Date();
        if (null == channelInfoDto.getChannelId()) {
            // 新增
            channelInfoDto.setCreateTime(now);
            channelInfoDto.setModifyTime(now);
            this.create(channelInfoDto);
        } else {
            // 修改
            channelInfoDto.setModifyTime(now);
            this.modifyEntityById(channelInfoDto);
            // 清除渠道对接人信息
            this.channelStaffService.clearChannelStaffByChannelId(channelInfoDto.getChannelId());
        }

        // 新增渠道对接人信息
        if (!CollectionUtils.isEmpty(channelInfoDto.getStaffInfos())) {
            channelInfoDto.getStaffInfos().forEach(staff -> {
                staff.setChannelId(channelInfoDto.getChannelId());
                staff.setCreateTime(new Date());
                this.channelStaffService.create(staff);
            });
        }

    }

    @Override
    @Transactional
    public void deleteChannelById(Long channelId) {
        this.deleteEntityById(channelId);
        this.channelStaffService.clearChannelStaffByChannelId(channelId);
    }

	

	@Override
	public void saveCaseRel(Map<String, Object>  param) {
		channelInfoDao.deleteCaseRel(param);
		channelInfoDao.saveCaseRel(param);
	}

	@Override
	public List<Map<String, Object>> areaName() {
		return channelInfoDao.areaName();
	}

}
