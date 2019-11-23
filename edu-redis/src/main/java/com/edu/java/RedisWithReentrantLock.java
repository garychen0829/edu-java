package com.edu.java;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisWithReentrantLock {

    private static final int EXPIRE_TIME = 5;

    private ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<>();
    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private boolean _lock(String key) {
        Long nx = jedis.setnx(key, "");
        jedis.expire(key, 5);
//        String setnx = jedis.set(key, "", SetParams.setParams().nx().ex(3));
        System.out.println(nx);
        return nx != null;
    }

    private void _unlock(String key) {
        jedis.del(key);
    }

    private Map<String, Integer> currentLockers() {
//        System.out.println(JSONObject.toJSONString(lockers));
        Map<String, Integer> refs = lockers.get();
        if (refs != null) {
            return refs;
        }
        lockers.set(new HashMap<>());
        return lockers.get();
    }

    public boolean lock(String key) {
        Map<String, Integer> refs = currentLockers();
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
        Map<String, Integer> refs = currentLockers();
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

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(redis.lock("codehole"));
        Thread.sleep(6000);
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.unlock("codehole"));
        System.out.println(redis.unlock("codehole"));
    }
}
