package com.loan.service.model.dto;

/**
 * @author GuoKang
 * @date 2019/6/24 10:50
 */
public class CaseCountBlockDto {

    private String blockType;
    private Long caseCount;

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public Long getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Long caseCount) {
        this.caseCount = caseCount;
    }
}
