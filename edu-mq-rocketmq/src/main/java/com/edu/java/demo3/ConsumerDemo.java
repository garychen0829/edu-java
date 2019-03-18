package com.edu.java.demo3;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/12
 */
public class ConsumerDemo {

    private String consumerGroupName;
    private String nameServerAddr;
    private String topicName;
    private DefaultMQPushConsumer consumer;
    private MessageListenerConcurrently messageListener;

    public ConsumerDemo(String consumerGroupName, String nameServerAddr, String topicName, MessageListenerConcurrently messageListener) {
        this.consumerGroupName = consumerGroupName;
        this.nameServerAddr = nameServerAddr;
        this.topicName = topicName;
        this.messageListener = messageListener;
    }

    public void init() throws Exception {
        System.out.println("开始启动消息消费者服务.");
        consumer = new DefaultMQPushConsumer(consumerGroupName);

        consumer.setNamesrvAddr(nameServerAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(topicName, "*");
        consumer.registerMessageListener(messageListener);
        consumer.start();

        System.out.println("消息消费者服务启动成功.");
    }

    public void destory() {
        System.out.println("开始关闭消息消费者服务...");

        consumer.shutdown();
        System.out.println("消息消费者服务已关闭...");

    }

    public DefaultMQPushConsumer getConsumer() {
        return consumer;
    }
}
