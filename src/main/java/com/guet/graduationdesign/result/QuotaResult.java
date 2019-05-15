package com.guet.graduationdesign.result;

/**
* @Description:    体征采集结果
* @Author:         TJX
* @CreateDate:     2019-05-13 19:50
* @UpdateUser:
* @UpdateDate:     2019-05-13 19:50
* @UpdateRemark:
* @Version:        1.0
*/
public class QuotaResult {

    private Integer heartRate;
    private Integer breatheRate;
    private Float temperature;

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getBreatheRate() {
        return breatheRate;
    }

    public void setBreatheRate(Integer breatheRate) {
        this.breatheRate = breatheRate;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "QuotaResult{" +
                "heartRate=" + heartRate +
                ", breatheRate=" + breatheRate +
                ", temperature=" + temperature +
                '}';
    }
}
