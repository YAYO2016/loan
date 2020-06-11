package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.MaterialBelong;
import com.loan.service.enums.MaterialType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019/4/25 10:58
 */
public class MaterialInfo extends AbsPojoSetPk implements Serializable {
    private Long materialId; // 材料ID
    private String materialName; // 材料名称
    private MaterialBelong materialBelong; // 材料归属
    private MaterialType materialType; // 材料类型
    private Long createUser; // 创建人ID
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public MaterialBelong getMaterialBelong() {
        return materialBelong;
    }

    public void setMaterialBelong(MaterialBelong materialBelong) {
        this.materialBelong = materialBelong;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public void setPk(Long pk) {
        setMaterialId(pk);
    }
}
