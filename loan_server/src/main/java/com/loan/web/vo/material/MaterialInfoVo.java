package com.loan.web.vo.material;

import com.loan.service.enums.MaterialBelong;
import com.loan.service.enums.MaterialType;

/**
 * @author GuoKang
 * @date 2019/4/25 15:36
 */
public class MaterialInfoVo {
    private Long materialId; // 材料ID
    private String materialName; // 材料名称
    private MaterialBelong materialBelong; // 材料归属
    private MaterialType materialType; // 材料类型
    private Long createUser; // 创建人ID

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
}
