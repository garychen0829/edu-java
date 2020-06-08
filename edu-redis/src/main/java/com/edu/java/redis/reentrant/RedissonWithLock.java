package com.edu.java.redis.reentrant;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Redisson 分布式重入锁用法
 * Redisson 支持单点模式、主从模式、哨兵模式、集群模式，这里以单点模式为例
 * Redisson 这个框架重度依赖了Lua脚本和Netty
 *
 * 官方文档说明
 * @link https://github.com/redisson/redisson/wiki/8.-Distributed-locks-and-synchronizers
 *
 * @author huichen
 * @date 2020-06
 */
public class RedissonWithLock {

    /**
     * RedissonClient lock&unlock的使用
     */
    public void execute() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        RedissonClient redissonClient = Redisson.create(config);
        // 获取锁对象实例（无法保证是按线程的顺序获取到）
        RLock rLock = redissonClient.getLock("codehole");

        // 尝试获取锁的最大等待时间, 超过这个时间即获取锁失败
        long waitTimeout = 1L;
        // 持有锁的时间, 相当于 redis.expire()
        long leaseTime = 10L;
        try {
            // 尝试获取
            boolean bool = rLock.tryLock(waitTimeout, leaseTime, TimeUnit.SECONDS);
            if (bool) {
                // do 业务代码..
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("aquire lock fail");
        } finally {
            //无论如何, 最后都要解锁
            rLock.unlock();
        }
    }
}
