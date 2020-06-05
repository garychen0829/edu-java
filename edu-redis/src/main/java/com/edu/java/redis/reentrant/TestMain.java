package com.edu.java.redis.reentrant;

import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;

public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(LocalDateTime.now() + " >>> " + redis.lock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.lock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.unlock("codehole"));
        System.out.println(LocalDateTime.now() + " >>> " + redis.unlock("codehole"));
    }
}
