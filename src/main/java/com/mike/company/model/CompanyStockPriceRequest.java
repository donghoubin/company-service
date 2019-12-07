package com.mike.company.model;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/6 23:24.
 */
public class CompanyStockPriceRequest {

    private String companyId;

    private String startTime;

    private String endTime;

    private String periodicity;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
}
