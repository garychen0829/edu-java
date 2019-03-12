package com.edu.java.demo3;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/12
 */
public class ProducerDemo {
    private Logger logger = LoggerFactory.getLogger(ProducerDemo.class);

    private String producerGroupName;
    private String nameServerAddr;
    private DefaultMQProducer producer;

    public ProducerDemo(String producerGroupName, String nameServerAddr) {
        this.producerGroupName = producerGroupName;
        this.nameServerAddr = nameServerAddr;
    }

    public void init() throws Exception {
        System.out.println("开始启动消息生产者服务...");

        producer = new DefaultMQProducer(producerGroupName);
        producer.setNamesrvAddr(nameServerAddr);
        producer.start();

        System.out.println("消息生产者服务启动成功...");
    }

    public void destroy() {
        System.out.println("开始关闭消息生产者服务...");

        producer.shutdown();

        System.out.println("消息生产者服务已关闭...");
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }
}
