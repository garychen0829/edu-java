package com.edu.java.demo4.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/12
 */
public class OrderProduct {
    private String producerGroupName;
    private String nameServerAddr;
    private DefaultMQProducer producer;

    public OrderProduct(String producerGroupName, String nameServerAddr) {
        this.producerGroupName = producerGroupName;
        this.nameServerAddr = nameServerAddr;
    }

    public void init() throws MQClientException {
        System.out.println("开始启动生产者服务...");
        producer = new DefaultMQProducer(producerGroupName);
        producer.setNamesrvAddr(nameServerAddr);
        producer.start();

        System.out.println("生产者服务启动成功");
    }

    public void destory() {
        System.out.println("开始关闭生产服务..");
        producer.shutdown();
        System.out.println("生产服务已经关闭..");
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }
}
