package com.edu.java.example3;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/26
 */
public class PubChannel {

    private static final String EXCHANGE_NAME = "logs";


    public static void main(String[] args) throws Exception {
        PubChannel channel = new PubChannel();
        channel.pub();
    }

    public void pub() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        //BuiltinExchangeType.FANOUT : 将接收到的所有消息广播到它所知道的所有队列
        //
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        String message = "hello pub...";

        for (int i = 1; i < 100; i++) {
            Thread.sleep(500);
            message += " " + i;
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}
