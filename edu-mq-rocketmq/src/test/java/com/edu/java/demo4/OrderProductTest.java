package com.edu.java.demo4;

import com.alibaba.fastjson.JSONObject;
import com.edu.java.demo4.producer.OrderMessage;
import com.edu.java.demo4.producer.OrderMessageQueueSelector;
import com.edu.java.demo4.producer.OrderProduct;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/12
 */
public class OrderProductTest {

    @Test
    public void sendMessage() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-order-producer.xml");
        OrderProduct product = context.getBean(OrderProduct.class);
        OrderMessageQueueSelector messageQueueSelector = context.getBean(OrderMessageQueueSelector.class);

        String topicName = "topic_example_order";
        String[] statusNames = {"已创建", "已付款", "已配送", "已取消", "已完成"};

        //模拟订单消息
        for (int orderId = 0; orderId <= 10; orderId++) {
            //模拟订单的每个状态来发送消息
            for (int i = 0; i < statusNames.length; i++) {
                OrderMessage orderMessage = new OrderMessage();
                orderMessage.setId(orderId);
                orderMessage.setStatus(statusNames[i]);
                orderMessage.setSendOrder(i);
                orderMessage.setContent("hello orderly rocketMQ message!");
                String messageContent = orderMessage.toString();

                Message sendMessage = new Message(topicName, statusNames[i], orderId + " # " + statusNames[i], messageContent.getBytes(RemotingHelper.DEFAULT_CHARSET));
                System.out.println(JSONObject.toJSONString(sendMessage));
                SendResult sendResult = product.getProducer().send(sendMessage, messageQueueSelector, orderId);
                System.out.printf("%s %n", sendResult);

            }
        }
    }
}
