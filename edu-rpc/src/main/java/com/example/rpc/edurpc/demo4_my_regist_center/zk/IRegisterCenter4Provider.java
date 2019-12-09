package com.example.rpc.edurpc.demo4_my_regist_center.zk;

import com.example.rpc.edurpc.demo4_my_regist_center.ProviderService;

import java.util.List;
import java.util.Map;

/**
 * 消费端注册中心接口
 *
 * @author hui2.chen
 * @date 2019/11/13
 */
public interface IRegisterCenter4Provider {

    /**
     * 服务端将提供者的信息注册到zk下
     * @param serviceMetaData
     */
    void registerProvider(List<ProviderService> serviceMetaData);

    /**
     * 获取所有注册的服务信息
     * @return
     */
    Map<String, List<ProviderService>> getProviderServiceMap();
}
