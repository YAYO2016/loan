package com.loan.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseCfgInfoDao;
import com.loan.service.enums.CaseCfgType;
import com.loan.service.model.CaseCfgInfo;
import com.loan.service.model.dto.CaseCfgInfoDto;
import com.loan.service.service.CaseCfgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-10 22:41
 */
@Service
public class CaseCfgInfoServiceImpl extends AbstractLoanService<CaseCfgInfo> implements CaseCfgInfoService {

    @Autowired
    private CaseCfgInfoDao caseCfgInfoDao;

    @Override
    protected ISingleTableDao<CaseCfgInfo> getMyBatisRepository() {
        return caseCfgInfoDao;
    }

    @Override
    protected CaseCfgInfo constructPkEntity(Long id) {
        return null;
    }

    @Override
    protected Object getPk(CaseCfgInfo caseCfgInfo) {
        return null;
    }

    @Override
    public void createCfgInfo(Long caseId, CaseCfgType caseCfgType, String content) {
        this.caseCfgInfoDao.insert(new CaseCfgInfo() {{
            setCaseId(caseId);
            setCfgType(caseCfgType);
            setCfgContent(content);
            setCreateTime(new Date());
        }});
    }

    @Transactional
    @Override
    public void clearCaseCfgInfo(Long caseId, List<CaseCfgType> caseCfgTypes) {
        this.caseCfgInfoDao.clearCaseCfgInfo(caseId, caseCfgTypes);
    }

    @Override
    public CaseCfgInfoDto getCaseCfgInfoDto(Long caseId, List<CaseCfgType> caseCfgTypes) {
        CaseCfgInfoDto cfgInfoDto = new CaseCfgInfoDto();
        cfgInfoDto.setCaseId(caseId);
        List<CaseCfgInfo> caseCfgInfos = this.queryEntityList(new CaseCfgInfo() {{
            setCaseId(caseId);
        }});

        if (CollectionUtils.isEmpty(caseCfgInfos)) return cfgInfoDto;

        caseCfgInfos.forEach(cfgInfo -> {
            if (StringUtils.isEmpty(cfgInfo.getCfgContent())) return;
            if (!caseCfgTypes.contains(cfgInfo.getCfgType())) return;

            switch (cfgInfo.getCfgType()) {
                case CHANNEL_INFO:
                    cfgInfoDto.setChannelInfo(JSON.parseObject(cfgInfo.getCfgContent()));
                    break;
                case DEVELOPER_INFO:
                    cfgInfoDto.setDeveloperInfo(JSON.parseObject(cfgInfo.getCfgContent()));
                    break;
                case ESTATE_INFO:
                    cfgInfoDto.setEstateInfo(JSON.parseObject(cfgInfo.getCfgContent()));
                    break;
                case ESTATE_SALESMAN_INFO:
                    cfgInfoDto.setEstateSalesmanInfo(JSON.parseObject(cfgInfo.getCfgContent()));
                    break;
                case MATERIAL_INFO:
                    cfgInfoDto.setMaterialInfo(JSON.parseArray(cfgInfo.getCfgContent()));
                    break;
                case FEE_ITEM_INFO:
                    cfgInfoDto.setFeeItemInfo(JSON.parseArray(cfgInfo.getCfgContent()));
                    break;
            }
        });

        return cfgInfoDto;
    }

    @Transactional
    @Override
    public void saveCaseCfgInfoDto(CaseCfgInfoDto caseCfgInfoDto, List<CaseCfgType> caseCfgTypes) {
        if (null == caseCfgInfoDto.getCaseId()) return;

        this.clearCaseCfgInfo(caseCfgInfoDto.getCaseId(), caseCfgTypes);

        caseCfgTypes.forEach(caseCfgType -> {
            Object contentJsonObj = null;
            switch (caseCfgType) {
                case CHANNEL_INFO:
                    contentJsonObj = caseCfgInfoDto.getChannelInfo();
                    break;
                case DEVELOPER_INFO:
                    contentJsonObj = caseCfgInfoDto.getDeveloperInfo();
                    break;
                case ESTATE_INFO:
                    contentJsonObj = caseCfgInfoDto.getEstateInfo();
                    break;
                case ESTATE_SALESMAN_INFO:
                    contentJsonObj = caseCfgInfoDto.getEstateSalesmanInfo();
                    break;
                case MATERIAL_INFO:
                    contentJsonObj = caseCfgInfoDto.getMaterialInfo();
                    break;
                case FEE_ITEM_INFO:
                    contentJsonObj = caseCfgInfoDto.getFeeItemInfo();
                    break;
            }
            if (!StringUtils.isEmpty(JSON.toJSONString(contentJsonObj))) {
                this.createCfgInfo(caseCfgInfoDto.getCaseId(),
                        caseCfgType,
                        JSON.toJSONString(contentJsonObj));
            }
        });
    }
}
