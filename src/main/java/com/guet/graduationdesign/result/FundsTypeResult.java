package com.guet.graduationdesign.result;

/**
* @Description:    资金类型返回结果
* @Author:         TJX
* @CreateDate:     2019-05-30 20:00
* @UpdateUser:
* @UpdateDate:     2019-05-30 20:00
* @UpdateRemark:
* @Version:        1.0
*/
public class FundsTypeResult {

    private String date;
    private Float purchase;
    private Float pay;
    private Float due;
    private Float fix;
    private Float other;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getPurchase() {
        return purchase;
    }

    public void setPurchase(Float purchase) {
        this.purchase = purchase;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public Float getDue() {
        return due;
    }

    public void setDue(Float due) {
        this.due = due;
    }

    public Float getFix() {
        return fix;
    }

    public void setFix(Float fix) {
        this.fix = fix;
    }

    public Float getOther() {
        return other;
    }

    public void setOther(Float other) {
        this.other = other;
    }
}
