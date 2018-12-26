package com.edu.java.example1;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/25
 */
public class Received {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Received received = new Received();
        received.sub();

    }
    /**
     * 接收
     */
    public void sub() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                String body = new String(delivery.getBody(),"utf-8");
                System.out.println(" [x] Received '" + body + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,consumerTag->{});
    }
}
