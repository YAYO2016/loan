package com.loan.service.service;

import com.loan.framework.service.service.LoanService;
import com.loan.service.enums.CaseCfgType;
import com.loan.service.model.CaseCfgInfo;
import com.loan.service.model.dto.CaseCfgInfoDto;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019-05-10 22:41
 */
public interface CaseCfgInfoService extends LoanService<CaseCfgInfo> {
    void createCfgInfo(Long caseId, CaseCfgType caseCfgType, String content);

    void clearCaseCfgInfo(Long caseId, List<CaseCfgType> caseCfgTypes);

    CaseCfgInfoDto getCaseCfgInfoDto(Long caseId, List<CaseCfgType> caseCfgTypes);

    void saveCaseCfgInfoDto(CaseCfgInfoDto caseCfgInfoDto, List<CaseCfgType> caseCfgTypes);
}
