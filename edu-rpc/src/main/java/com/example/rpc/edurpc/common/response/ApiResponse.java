package com.example.rpc.edurpc.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口统一返回
 *
 * @author hui2.chen
 * @date 2019/11/14
 */
@Data
public class ApiResponse<T> implements Serializable {
    private boolean success;
    private String code;
    private String msg;
    private T data;


    public static <T> ApiResponse<T> buildSuccess() {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setSuccess(true);
        return response;
    }

    public static <T> ApiResponse<T> buildSuccess(T data) {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static <T> ApiResponse<T> buildFail() {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setSuccess(false);
        return response;
    }

    public static <T> ApiResponse<T> buildFail(String msg) {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setSuccess(false);
        response.setMsg(msg);
        return response;
    }

    public static <T> ApiResponse<T> buildFail(String code, String msg) {
        ApiResponse<T> response = new ApiResponse<T>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

}
