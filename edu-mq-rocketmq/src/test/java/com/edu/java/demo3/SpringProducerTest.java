package com.edu.java.demo3;

import com.edu.java.demo3.ProducerDemo;
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
public class SpringProducerTest {

    @Test
    public void sendMessage() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-producer.xml");
        ProducerDemo producerDemo = context.getBean(ProducerDemo.class);
        for (int i = 0; i < 20; i++) {
            Message msg = new Message("spring-rocketMQ-topic",null, ("Spring RocketMQ demo "  + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producerDemo.getProducer().send(msg);
            System.out.printf("%s%n", sendResult);
        }
    }
}
