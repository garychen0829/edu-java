package com.edu.java.demo4;

import com.edu.java.demo4.consumer.OrderConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/13
 */
public class OrderConsumerTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-order-consumer.xml");
        OrderConsumer consumer = context.getBean(OrderConsumer.class);

        Thread.sleep(200 * 1000);

        consumer.destroy();
    }

}
