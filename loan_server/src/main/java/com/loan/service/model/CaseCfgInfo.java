package com.loan.service.model;

import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.CaseCfgType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoKang
 * @date 2019-05-10 22:25
 */
public class CaseCfgInfo extends AbsPojoSetPk implements Serializable {
    private Long caseId; // 案子ID
    private CaseCfgType cfgType; // 配置信息类型
    private String cfgContent; // 配置信息内容，json形式
    private Date createTime; // 创建时间

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public CaseCfgType getCfgType() {
        return cfgType;
    }

    public void setCfgType(CaseCfgType cfgType) {
        this.cfgType = cfgType;
    }

    public String getCfgContent() {
        return cfgContent;
    }

    public void setCfgContent(String cfgContent) {
        this.cfgContent = cfgContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setPk(Long pk) {

    }
}
