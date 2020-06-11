package com.framework.mybatis.mysql.pojo;

public class CfgDict {
    private String dictId;

    private String dictName;

    private String superDictId;

    private String isValid;

    private String dictTabName;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getSuperDictId() {
        return superDictId;
    }

    public void setSuperDictId(String superDictId) {
        this.superDictId = superDictId == null ? null : superDictId.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getDictTabName() {
        return dictTabName;
    }

    public void setDictTabName(String dictTabName) {
        this.dictTabName = dictTabName == null ? null : dictTabName.trim();
    }
}