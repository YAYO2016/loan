package com.loan.service.model.dto;

/**
 * @author GuoKang
 * @date 2019-05-30 19:54
 */
public class CaseCountChartDto {

    private String period;
    private Long caseCount;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Long caseCount) {
        this.caseCount = caseCount;
    }
}
