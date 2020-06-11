package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/26 10:33
 */
public class EstateInfo extends AbsPojoSetPk implements Serializable {

    private Long estateId; // 楼盘ID
    private Long developerId; // 开发商ID
    private String estateName; // 楼盘名称
    private String estateTel; // 楼盘电话
    private String estateAddr; // 楼盘地址
    private String managerName; // 楼盘负责人姓名
    private String managerTel; // 负责人电话
    private Date createTime; // 创建时间

    public Long getEstateId() {
        return estateId;
    }

    public void setEstateId(Long estateId) {
        this.estateId = estateId;
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getEstateTel() {
        return estateTel;
    }

    public void setEstateTel(String estateTel) {
        this.estateTel = estateTel;
    }

    public String getEstateAddr() {
        return estateAddr;
    }

    public void setEstateAddr(String estateAddr) {
        this.estateAddr = estateAddr;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {
        setEstateId(pk);
    }
}
