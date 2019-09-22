package com.jxnu.demo.commoon;

public enum ReturnCode implements CommonReturn{
    //成功:X1   失败:X0
    //查找：3x   插入：4x  更新：5x  删除：6x  空指针：9x
    SUCCESS(11,"成功"),
    ERROR(20,"失败"),
    SELECT_ERROR(30,"查找失败"),
    SELECT_SUCCESS(31,"查找成功"),
    INSERT_ERROR(40,"插入失败"),
    INSERT_SUCCESS(41,"插入成功"),
    UPDATE_ERROR(50,"更新失败"),
    UPDATE_SUCCESS(51,"更新成功"),
    DELETE_ERROR(60,"删除失败"),
    DELETE_SUCCESS(61,"删除成功"),
    NULL_ERROR(90,"空指针异常")

    ;

    private String Msg;
    private int Code;
    ReturnCode(int code, String errMsg) {
        this.Msg=errMsg;
        this.Code=code;
    }

    @Override
    public String getMsg() {
        return Msg;
    }
    @Override
    public int getCode() {
        return Code;
    }
    @Override
    public ReturnCode setMsg(String Msg) {
        this.Msg=Msg;
        return this;
    }
}
