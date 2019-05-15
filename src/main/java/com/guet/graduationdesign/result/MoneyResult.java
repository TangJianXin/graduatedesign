package com.guet.graduationdesign.result;

import java.util.Date;

public class MoneyResult {

    private Float income;
    private Float outlay;
    private Float profit;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Float getOutlay() {
        return outlay;
    }

    public void setOutlay(Float outlay) {
        this.outlay = outlay;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }
}
