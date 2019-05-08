package com.guet.graduationdesign.result;

/**
* @Description:    登录返回结果
* @Author:         TJX
* @CreateDate:     2019-05-08 12:06
* @UpdateUser:
* @UpdateDate:     2019-05-08 12:06
* @UpdateRemark:
* @Version:        1.0
*/
public class LoginResult<T> {

    private T entity;
    private String role;
    private String url;

    @Override
    public String toString() {
        return "LoginResult{" +
                "entity=" + entity +
                ", role='" + role + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
