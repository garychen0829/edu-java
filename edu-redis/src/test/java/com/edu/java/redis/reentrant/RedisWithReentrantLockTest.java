package com.edu.java.redis.reentrant;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;


public class RedisWithReentrantLockTest {

    @Test
    public void test_lock_unlock() {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(LocalDateTime.now() + " >>> " + redis.lock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.lock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.lock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.unlock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.unlock("codehole"));
    }

    /**
     * 实战训练
     */
    @Test
    public void test_training_lock() {

    }
}