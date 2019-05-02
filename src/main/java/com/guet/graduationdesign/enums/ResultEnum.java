package com.guet.graduationdesign.enums;

public enum ResultEnum {

    ADD_SUCCESS(1, "添加成功"),
    UPDATE_SUCCESS(2, "修改成功"),
    DELETE_SUCCESS(3, "删除成功"),
    SELECT_SUCCESS(4, "查询成功"),
    LOGIN_SUCCESS(5,"登录成功"),
    REGISTER_SUCCESS(6,"注册成功"),
    UPLOAD_SUCCESS(7,"上传成功"),
    ADD_FAIL(8, "添加失败"),
    UPDATE_FAIL(9, "更新失败"),
    DELETE_FAIL(10,"删除失败"),
    SELETCT_FAIL(11,"查询失败"),
    REGISTER_FAIL(12,"注册失败"),
    LOGIN_FAIL(13,"登录失败"),
    UPLOAD_FAIL(14,"上传失败"),
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