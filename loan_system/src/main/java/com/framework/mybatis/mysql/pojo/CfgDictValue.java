package com.framework.mybatis.mysql.pojo;

public class CfgDictValue {
    private String dictId;

    private String dictValue;

    private String dictValueName;

    private String superValueId;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictValueName() {
        return dictValueName;
    }

    public void setDictValueName(String dictValueName) {
        this.dictValueName = dictValueName == null ? null : dictValueName.trim();
    }

    public String getSuperValueId() {
        return superValueId;
    }

    public void setSuperValueId(String superValueId) {
        this.superValueId = superValueId == null ? null : superValueId.trim();
    }
}