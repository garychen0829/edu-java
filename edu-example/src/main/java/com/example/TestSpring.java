package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/2/18
 */
public class TestSpring {
    public static void main(String[] args) {
        TestSpring spring = new TestSpring();
        try {
            boolean b = spring.testBoolean();
            System.out.println(b);
        } catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();

        }
    }


    public boolean testBoolean() throws Exception {
        if (true) {
            throw new Exception("exception...");
        }
        return false;
    }
}
