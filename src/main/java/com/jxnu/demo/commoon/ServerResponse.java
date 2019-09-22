package com.jxnu.demo.commoon;


import java.io.Serializable;

public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public ServerResponse(int status) {
        this.status = status;
    }
    public ServerResponse(int status,T data) {
        this.status = status;
        this.data = data;
    }

    public static<T> ServerResponse<T> CreateServerResponse(int status, String msg, T data) {
        return new ServerResponse<T>(status,msg,data);
    }

    public static<T> ServerResponse<T> CreateServerResponse(int status, String msg) {
        return new ServerResponse<T>(status,msg);
    }

    public static<T> ServerResponse<T> CreateServerResponse(int status,T data) {
        return new ServerResponse<T>(status,data);
    }

    public static<T> ServerResponse<T> CreateServerResponse(int status) {
        return new ServerResponse<T>(status);
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
