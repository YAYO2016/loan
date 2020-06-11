package com.loan.service.model.dto;

import com.loan.service.model.DeveloperInfo;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/26 11:22
 */
public class DeveloperInfoDto extends DeveloperInfo {

    private String createUserName;

    private List<EstateInfoDto> estateInfos;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public List<EstateInfoDto> getEstateInfos() {
        return estateInfos;
    }

    public void setEstateInfos(List<EstateInfoDto> estateInfos) {
        this.estateInfos = estateInfos;
    }
}
