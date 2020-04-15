package com.queue.demo1;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 一个缓存的具体类。
 * 包含缓存失效时间，以及失效内容
 */
public class DataCache implements Delayed {

    private String msg;
    //缓存的失效时间
    private long expireTime = 0;


    @Override
    public long getDelay(TimeUnit timeUtil) {
        return timeUtil.convert(this.getExpireTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
