package com.example.rpc.edurpc.demo4_my_regist_center;

import avro.shaded.com.google.common.collect.Lists;
import com.example.rpc.edurpc.common.IPHelper;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 描述:
 *
 * @author hui2.chen
 * @date 2019/11/14
 */
@Data
public class ProviderBean implements FactoryBean, InitializingBean {
    /**
     * 服务接口
     */
    private Class<?> serviceItf;
    /**
     * 服务实现
     */
    private Object serviceObject;
    /**
     * 服务端口
     */
    private String serverPort;
    /**
     * 服务超时时间
     */
    private long timeout;
    /**
     * 服务代理对象,暂时没有用到
     */
    private Object serviceProxyObject;
    /**
     * 服务提供者唯一标识
     */
    private String appKey;
    /**
     * 服务分组组名
     */
    private String groupName = "default";
    /**
     * 服务提供者权重,默认为1 ,范围为[1-100]
     */
    private int weight = 1;
    /**
     * 服务端线程数,默认10个线程
     */
    private int workerThreads = 10;

    @Override
    public Object getObject() throws Exception {
        return serviceProxyObject;
    }

    @Override
    public Class<?> getObjectType() {
        return serviceItf;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    private List<ProviderService> buildProviderServiceInfos() {
        List<ProviderService> providerList = Lists.newArrayList();
        Method[] methods = serviceObject.getClass().getDeclaredMethods();
        for (Method method : methods) {
            ProviderService providerService = new ProviderService();
            providerService.setServiceItf(serviceItf);
            providerService.setServiceObject(serviceObject);
            providerService.setServerIp(IPHelper.localIp());
            providerService.setServerPort(Integer.parseInt(serverPort));
            providerService.setTimeout(timeout);
            providerService.setServiceMethod(method);
            providerService.setWeight(weight);
            providerService.setWorkerThreads(workerThreads);
            providerService.setAppKey(appKey);
            providerService.setGroupName(groupName);
            providerList.add(providerService);
        }
        return providerList;
    }
}
