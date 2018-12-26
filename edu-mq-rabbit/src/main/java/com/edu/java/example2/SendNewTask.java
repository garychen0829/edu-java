package com.edu.java.example2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/25
 */
public class SendNewTask {
    //消息队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        SendNewTask send = new SendNewTask();
        send.pub();

    }

    /**
     * 发送
     */
    public void pub() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        for (int i = 1; i < 100; i++) {
            String body = "[" + i + "] send message...";
            String message = String.join(" ", body);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }

    }
}
