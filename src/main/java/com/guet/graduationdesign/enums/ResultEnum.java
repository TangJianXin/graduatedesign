package com.guet.graduationdesign.enums;

public enum ResultEnum {

    ADD_SUCCESS(1, "添加成功"),
    UPDATE_SUCCESS(1, "修改成功"),
    DELETE_SUCCESS(1, "删除成功"),
    SELECT_SUCCESS(1, "查询成功"),
    LOGIN_SUCCESS(1,"登录成功"),
    REGISTER_SUCCESS(1,"注册成功"),
    UPLOAD_SUCCESS(1,"上传成功"),
    GETFILE_SUCCESS(1,"获取成功"),
    ADD_FAIL(0, "添加失败"),
    UPDATE_FAIL(0, "更新失败"),
    DELETE_FAIL(0,"删除失败"),
    SELETCT_FAIL(0,"查询失败"),
    REGISTER_FAIL(0,"注册失败"),
    LOGIN_FAIL(0,"登录失败"),
    UPLOAD_FAIL(0,"上传失败"),
    GETFILE_FAIL(0,"获取失败"),
    UNKONW_EXCEPTION(-1, "未知错误");


    private Integer code;
    private String message;
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}