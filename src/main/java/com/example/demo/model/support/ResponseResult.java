package com.example.demo.model.support;

import lombok.Data;

@Data
public class ResponseResult<T> {

    private Integer code;

    private boolean status;

    private String message;

    private T data;

    public ResponseResult() {
        this.code = 200;
        this.status = true;
        this.message = null;
        this.data = null;
    }

    //不附带msg返回数据
    public ResponseResult(T data) {
        this.code = 200;
        this.status = true;
        this.message = null;
        this.data = data;
    }

    //默认附带msg返回数据
    public ResponseResult(String message, T data) {
        this.code = 200;
        this.status = true;
        this.message = message;
        this.data = data;
    }

    //默认的错误返回
    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.status = false;
        this.message = message;
        this.data = null;
    }


}
