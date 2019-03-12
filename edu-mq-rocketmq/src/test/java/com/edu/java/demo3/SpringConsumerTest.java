package com.edu.java.demo3;

import com.edu.java.demo3.ConsumerDemo;
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
public class SpringConsumerTest {

    @Test
    public void consumer() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-consumer.xml");
        ConsumerDemo consumer = context.getBean(ConsumerDemo.class);
        Thread.sleep(20 * 1000);
        consumer.destory();
    }
}
