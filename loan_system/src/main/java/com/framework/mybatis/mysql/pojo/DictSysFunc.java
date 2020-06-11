package com.framework.mybatis.mysql.pojo;

public class DictSysFunc {
    private String funcId;

    private String funcName;

    private String superFuncId;

    private String funcType;

    private Integer seqNum;

    private String funcUrl;

    private String menuPicture;

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getSuperFuncId() {
        return superFuncId;
    }

    public void setSuperFuncId(String superFuncId) {
        this.superFuncId = superFuncId == null ? null : superFuncId.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getMenuPicture() {
        return menuPicture;
    }

    public void setMenuPicture(String menuPicture) {
        this.menuPicture = menuPicture == null ? null : menuPicture.trim();
    }
}