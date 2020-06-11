package com.loan.service.model.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author GuoKang
 * @date 2019/5/10 16:22
 */
public class CaseCfgInfoDto {
    private Long caseId;
    private JSONObject developerInfo;
    private JSONObject estateInfo;
    private JSONObject estateSalesmanInfo;
    private JSONObject channelInfo;
    private JSONArray materialInfo;
    private JSONArray feeItemInfo;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public JSONObject getDeveloperInfo() {
        return developerInfo;
    }

    public void setDeveloperInfo(JSONObject developerInfo) {
        this.developerInfo = developerInfo;
    }

    public JSONObject getEstateInfo() {
        return estateInfo;
    }

    public void setEstateInfo(JSONObject estateInfo) {
        this.estateInfo = estateInfo;
    }

    public JSONObject getEstateSalesmanInfo() {
        return estateSalesmanInfo;
    }

    public void setEstateSalesmanInfo(JSONObject estateSalesmanInfo) {
        this.estateSalesmanInfo = estateSalesmanInfo;
    }

    public JSONObject getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(JSONObject channelInfo) {
        this.channelInfo = channelInfo;
    }

    public JSONArray getMaterialInfo() {
        return materialInfo;
    }

    public void setMaterialInfo(JSONArray materialInfo) {
        this.materialInfo = materialInfo;
    }

    public JSONArray getFeeItemInfo() {
        return feeItemInfo;
    }

    public void setFeeItemInfo(JSONArray feeItemInfo) {
        this.feeItemInfo = feeItemInfo;
    }
}
