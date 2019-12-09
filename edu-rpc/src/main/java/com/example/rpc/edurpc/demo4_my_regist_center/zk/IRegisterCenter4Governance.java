package com.example.rpc.edurpc.demo4_my_regist_center.zk;

import com.example.rpc.edurpc.demo4_my_regist_center.InvokerService;
import com.example.rpc.edurpc.demo4_my_regist_center.ProviderService;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * 服务治理接口
 *
 * @author liyebing created on 17/4/26.
 * @version $Id$
 */
public interface IRegisterCenter4Governance {

    /**
     * 获取服务提供者列表与服务消费者列表
     *
     * @param serviceName
     * @param appKey
     * @return
     */
    public Pair<List<ProviderService>, List<InvokerService>> queryProvidersAndInvokers(String serviceName, String appKey);


}
