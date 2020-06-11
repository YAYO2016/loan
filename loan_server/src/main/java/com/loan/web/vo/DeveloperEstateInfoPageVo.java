package com.loan.web.vo;

/**
 * @author GuoKang
 * @date 2019/4/26 14:07
 */
public class DeveloperEstateInfoPageVo {

    private Long developerId; // 开发商ID
    private String developerName; // 开发商名称
    private String developerAddr; // 开发商地址
    private Long estateId; // 楼盘ID
    private String estateName; // 楼盘名称
    private String estateAddr; // 楼盘地址

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperAddr() {
        return developerAddr;
    }

    public void setDeveloperAddr(String developerAddr) {
        this.developerAddr = developerAddr;
    }

    public Long getEstateId() {
        return estateId;
    }

    public void setEstateId(Long estateId) {
        this.estateId = estateId;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getEstateAddr() {
        return estateAddr;
    }

    public void setEstateAddr(String estateAddr) {
        this.estateAddr = estateAddr;
    }
}
