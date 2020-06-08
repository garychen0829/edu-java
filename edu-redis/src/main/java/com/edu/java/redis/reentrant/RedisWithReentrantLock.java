package com.edu.java.redis.reentrant;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 分布式锁
 * <p>
 * set, setnx(set if not exists), expire, del, get
 *
 * <p>实现原理</p>
 * 1. 加锁：执行setnx，若成功再执行expire添加过期时间
 * 2. 解锁：执行delete命令
 *
 * @author chenh
 * @date 2020-05
 */
public class RedisWithReentrantLock {

    private static final int EXPIRE_TIME = 5;

    private ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<>();
    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 加锁
     *
     * 弊端: 该方案有一个致命问题，由于setnx和expire是两条Redis命令，不具备原子性，如果一个线程在执行完setnx()之后突然崩溃，导致锁没有设置过期时间，那么将会发生死锁。
     * jedis.setnx(key, "");
     * jedis.expire(key, 5);
     *
     * Redis2.6.12以上版本为set命令增加了可选参数
     * 我们对锁设置了过期时间，即使锁的持有者后续发生崩溃而没有解锁，锁也会因为到了过期时间而自动解锁（即key被删除），不会发生死锁。
     */
    private boolean _lock(String key) {
        String setnx = jedis.set(key, "", SetParams.setParams().nx().ex(EXPIRE_TIME));
        return setnx != null;
    }

    /**
     * 释放锁
     *
     * @param key
     */
    private void _unlock(String key) {
        jedis.del(key);
    }

    private Map<String, Integer> currentLockers() {
        Map<String, Integer> refs = lockers.get();
        System.out.println("get=" + JSONObject.toJSONString(refs));
        if (refs != null) {
            return refs;
        }
        lockers.set(new HashMap<>());
        System.out.println("set");
        return lockers.get();
    }

    public boolean lock(String key) {
        Map<String, Integer> refs = this.currentLockers();
        Integer refCnt = refs.get(key);

        if (refCnt != null) {
            refs.put(key, refCnt - 1);
            return true;
        }
        boolean ok = this._lock(key);
        if (!ok) {
            return false;
        }
        refs.put(key, 1);
        return true;
    }

    public boolean unlock(String key) {
        Map<String, Integer> refs = this.currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt == null) {
            return false;
        }
        refCnt -= 1;
        if (refCnt > 0) {
            refs.put(key, refCnt);
        } else {
            refs.remove(key);
            this._unlock(key);
        }
        return true;
    }
}
