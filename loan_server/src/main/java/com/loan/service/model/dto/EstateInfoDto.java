package com.loan.service.model.dto;

import com.loan.service.model.DeveloperInfo;
import com.loan.service.model.EstateInfo;
import com.loan.service.model.EstateSalesmanInfo;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/26 13:57
 */
public class EstateInfoDto extends EstateInfo {

    private DeveloperInfo developerInfo;

    private List<EstateSalesmanInfo> salesmanInfos;

    public DeveloperInfo getDeveloperInfo() {
        return developerInfo;
    }

    public void setDeveloperInfo(DeveloperInfo developerInfo) {
        this.developerInfo = developerInfo;
    }

    public List<EstateSalesmanInfo> getSalesmanInfos() {
        return salesmanInfos;
    }

    public void setSalesmanInfos(List<EstateSalesmanInfo> salesmanInfos) {
        this.salesmanInfos = salesmanInfos;
    }
}
