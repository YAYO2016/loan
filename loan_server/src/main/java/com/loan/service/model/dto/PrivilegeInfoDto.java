package com.loan.service.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loan.service.model.PrivilegeInfo;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/7/19 17:23
 */
public class PrivilegeInfoDto extends PrivilegeInfo {
    @JsonIgnore
    private PrivilegeInfoDto parent;
    private List<PrivilegeInfoDto> children;

    public PrivilegeInfoDto getParent() {
        return parent;
    }

    public void setParent(PrivilegeInfoDto parent) {
        this.parent = parent;
    }

    public List<PrivilegeInfoDto> getChildren() {
        return children;
    }

    public void setChildren(List<PrivilegeInfoDto> children) {
        this.children = children;
    }
}
