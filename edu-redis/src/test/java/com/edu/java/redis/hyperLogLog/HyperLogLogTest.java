package com.edu.java.redis.hyperLogLog;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class HyperLogLogTest {

    @Test
    public void testHyperLogLog() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        for (int i = 0; i < 100000; i++) {
            jedis.pfadd("codehole", "user" + i);
        }
        long total = jedis.pfcount("codehole");
        System.out.printf("%d %d\n", 100000, total);
        jedis.close();

    }
}
