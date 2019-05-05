package com.guet.graduationdesign.result;

import com.guet.graduationdesign.pojo.Employer;

/**
* @Description:    员工结果封装类
* @Author:         TJX
* @CreateDate:     2019-05-05 23:57
* @UpdateUser:
* @UpdateDate:     2019-05-05 23:57
* @UpdateRemark:
* @Version:        1.0
*/
public class EmployerResult {

    private Employer employer;
    private String url;

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EmployerResult{" +
                "employer=" + employer +
                ", url='" + url + '\'' +
                '}';
    }
}
