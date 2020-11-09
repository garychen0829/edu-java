package com.jd.demo1;

import com.OkHttpRequestBase;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import util.OkHttpUtils;
import util.RealCallback;


import java.io.IOException;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public class TestOkHttpDemo {

    public static void main(String[] args) {
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        String jsonObject = "{\"merchantCode\":\"2380000001_4748\",\"merchantUserId\":\"SFY0349400503\",\"jrOpenId\":\"1809384736475806504\",\"sign\":\"LS5Mep6bjwxkDc/W1Hnjx0QCPS2U4854Hbh/filjoIjegqTStKx9tkTuJN4ICdG1j6F9VCk3c2v3qZ9HrLNGCggkPKhkWBO2QPk0hVA3PvIB0ntkslUE/+TZqpLdIw3TaXiJwFtQlzfZFq3AsqlG+2df/sWyniJyRQ8/qnnHjPY=\",\"key\":\"Rf43GBcagNTUe3JZWdiWqlzaQNL8waQOHeAF4hiACbXk6CxQlREBTptdhgJ6/hHsRGI08inaiYVJ2dvLjAD/bLopuZWrqeXTZxFx/4kVoH0zhn7U2PDvhoDwwpGX9toycMstZfQOtEfss3urbVrbmX16DH1tW6feFBibTQTUdBA=\",\"charset\":\"UTF-8\",\"body\":\"w4hM/m3JqMFLH49wGAicpp17c6O9YeB3R1iOLBggaH0J3dAo8LHxsPEu0hbcM6nW\",\"type\":\"3011\",\"version\":\"1.0\"}";
        System.out.println("请求 \n" + jsonObject);
        okHttpUtils.post("http://test.btgateway.jd.com/service/gatewayproxy", RequestBody.create(MediaType.parse("application/json"), jsonObject), new RealCallback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println("success=" + JSONObject.toJSONString(response));
                if (response.isSuccessful()) {
                    System.out.println("code=" + response.code());
                    try {
                        System.out.println("body=" + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("error"+e);
            }
        });
    }

}
