package com.mike.company.model;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/6 23:22.
 */
public class CompanyStockPriceResponse {

    private String dates;

    private String currentPrice;

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }
}
