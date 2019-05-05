package com.guet.graduationdesign.result;

import com.guet.graduationdesign.pojo.OldPeople;

/**
* @Description:    老人结果封装类
* @Author:         TJX
* @CreateDate:     2019-05-05 23:57
* @UpdateUser:
* @UpdateDate:     2019-05-05 23:57
* @UpdateRemark:
* @Version:        1.0
*/
public class OldPeopleResult {

    private OldPeople oldPeople;
    private String url;

    @Override
    public String toString() {
        return "OldPeopleResult{" +
                "oldPeople=" + oldPeople +
                ", url='" + url + '\'' +
                '}';
    }

    public OldPeople getOldPeople() {
        return oldPeople;
    }

    public void setOldPeople(OldPeople oldPeople) {
        this.oldPeople = oldPeople;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

