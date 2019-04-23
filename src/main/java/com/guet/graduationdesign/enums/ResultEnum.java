package com.guet.graduationdesign.enums;

public enum ResultEnum {
    ADD_SUCCESS(1, "添加成功"),
    UPDATE_SUCCESS(2, "修改成功"),
    DELETE_SUCCESS(3, "删除成功"),
    SELECT_SUCCESS(4, "查询成功"),
    ADD_FAIL(5, "添加失败"),
    UPDATE_FAIL(6, "更新失败"),
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