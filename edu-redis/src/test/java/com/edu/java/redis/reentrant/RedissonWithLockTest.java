package com.edu.java.redis.reentrant;

import org.junit.Test;

public class RedissonWithLockTest {

    /**
     * 加锁和解锁过程中还巧妙地利用了redis的发布订阅功能
     *
     * @link https://github.com/redisson/redisson/blob/master/redisson/src/main/java/org/redisson/RedissonLock.java
     *
     * 可以通过ttl 来观察key的时效
     */
    @Test
    public void test_lock_unlock() {
        RedissonWithLock lock = new RedissonWithLock();
        lock.execute();
    }
}