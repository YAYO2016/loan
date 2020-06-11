package com.loan.service.service.impl;

import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.CaseCustInfoDao;
import com.loan.service.enums.CaseCustomerType;
import com.loan.service.model.CaseCustInfo;
import com.loan.service.model.dto.CaseCustInfoDto;
import com.loan.service.service.CaseCustInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author GuoKang
 * @date 2019-05-06 23:18
 */
@Service
public class CaseCustInfoServiceImpl extends AbstractLoanService<CaseCustInfo> implements CaseCustInfoService {

    @Autowired
    private CaseCustInfoDao caseCustInfoDao;

    @Override
    protected ISingleTableDao<CaseCustInfo> getMyBatisRepository() {
        return caseCustInfoDao;
    }

    @Override
    protected CaseCustInfo constructPkEntity(Long id) {
        return new CaseCustInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseCustInfo caseCustInfo) {
        return caseCustInfo.getCustId();
    }

    @Override
    public CaseCustInfoDto getCustInfoDtoByCaseCustomerType(Long caseId, CaseCustomerType type) {
        List<CaseCustInfo> allCustList = this.queryEntityList(new CaseCustInfo() {{
            setCaseId(caseId);
        }});

        CaseCustInfoDto caseCustInfoDto = new CaseCustInfoDto();
        caseCustInfoDto.setCaseId(caseId);
        caseCustInfoDto.setCaseCustType(type);

        List<CaseCustomerType> subTypes = CaseCustomerType.getSubType(type);
        // 入参type不是主贷或主卖人时，不返回信息
        if (CollectionUtils.isEmpty(subTypes) || (subTypes.size() <= 1 && subTypes.contains(type)))
            return caseCustInfoDto;

        // 找到当前主贷或主卖人
        allCustList.stream()
                .filter(cust -> type.equals(cust.getCaseCustType()))
                .findFirst()
                .ifPresent(cust -> BeanUtils.copyProperties(cust, caseCustInfoDto));

        // 找到共还人或共有人
        caseCustInfoDto.setOtherCusts(
                allCustList.stream()
                        .filter(cust -> subTypes.contains(cust.getCaseCustType()))
                        .collect(Collectors.toList()));
        return caseCustInfoDto;
    }

    @Transactional
    @Override
    public void saveCaseCustInfo(CaseCustInfoDto caseCustInfoDto) {
        if (null == caseCustInfoDto
                || null == caseCustInfoDto.getCaseId())
            return;
        Date now = new Date();
        if (null == caseCustInfoDto.getCustId()) {
            caseCustInfoDto.setCreateTime(now);
            this.create(caseCustInfoDto);
        } else {
            CaseCustInfo mainCust = this.getEntityById(caseCustInfoDto.getCustId());
            caseCustInfoDto.setCreateTime(mainCust.getCreateTime());
            this.modifyEntityById(caseCustInfoDto);
        }

        List<CaseCustomerType> subTypes = CaseCustomerType.getSubType(caseCustInfoDto.getCaseCustType());
        // 新增时，主要人必须是主贷或主卖人
        assert CaseCustomerType.BUYER_MAIN_CREDIT.equals(caseCustInfoDto.getCaseCustType())
                || CaseCustomerType.SELLER_HOUSE_OWNER.equals(caseCustInfoDto.getCaseCustType());

        // 清空干系人信息
        if (!CollectionUtils.isEmpty(subTypes))
            subTypes.forEach(type -> this.caseCustInfoDao.deleteEntityByCustType(new HashMap<String, Object>() {{
                                                                                     put("caseId", caseCustInfoDto.getCaseId());
                                                                                     put("caseCustType", type);
                                                                                 }}
            ));

        if (!CollectionUtils.isEmpty(caseCustInfoDto.getOtherCusts())) {
            caseCustInfoDto.getOtherCusts().forEach(custInfo -> {
                if (!subTypes.contains(custInfo.getCaseCustType())) return;
                custInfo.setCustId(null);
                custInfo.setCaseId(caseCustInfoDto.getCaseId());
                custInfo.setCreateTime(now);
                this.create(custInfo);
            });
        }

    }

}
