package com.edu.java.demo4.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/13
 */
public class OrderConsumer {
    private String consumerGroupName;
    private String nameServerAddr;
    private String topicName;
    private DefaultMQPushConsumer consumer;
    private MessageListenerConcurrently messageListener;

    public OrderConsumer(String consumerGroupName, String nameServerAddr, String topicName, MessageListenerConcurrently messageListener) {
        this.consumerGroupName = consumerGroupName;
        this.nameServerAddr = nameServerAddr;
        this.topicName = topicName;
        this.messageListener = messageListener;

    }

    public void init() throws Exception {
        System.out.println("开始启动消费者服务...");
        consumer = new DefaultMQPushConsumer(consumerGroupName);
        consumer.setNamesrvAddr(nameServerAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(topicName, "*");
        consumer.registerMessageListener(messageListener);
        consumer.start();
        System.out.println("消费者服务启动成功.");

    }

    public void destroy() {
        System.out.println("开始关闭消费者服务...");
        consumer.shutdown();
        System.out.println("消费者服务已关闭...");
    }
}
