package com.example.rpc.edurpc.demo4_my_regist_center;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author hui2.chen
 * @date 2019/11/13
 */
@Data
public class InvokerService implements Serializable {

    /**
     * 服务接口
     */
    private Class<?> serviceItf;
    /**
     * 超时时间
     */
    private Object serviceObject;
    /**
     * 服务方法
     */
    private Method serviceMethod;
    /**
     * 调用IP
     */
    private String invokerIp;
    /**
     * 调用端口
     */
    private int invokerPort;
    /**
     * 超时时间
     */
    private long timeout;
    /**
     * 服务提供者唯一标识
     */
    private String remoteAppKey;
    /**
     * 服务分组组名
     */
    private String groupName = "default";

}
