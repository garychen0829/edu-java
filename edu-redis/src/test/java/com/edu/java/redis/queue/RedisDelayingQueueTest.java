package com.edu.java.redis.queue;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisDelayingQueueTest {

    @Test
    public void delay() {
        Jedis jedis = new Jedis();
        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "q-demo");
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.delay("codehole" + i);
                }
            }
        });


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.loop();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            Thread.sleep(10 * 1000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {

        }
    }
}