package com.queue.delay.item;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列-泛型
 *
 * @author huichen
 */
public class DelayedItem<T> implements Delayed {

    private T t;
    //缓存的失效时间
    private long expireTime = 0;

    public DelayedItem(T t, long time, TimeUnit unit) {
        this.t = t;
        this.expireTime = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return expireTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedItem<T> item = (DelayedItem<T>) o;
        long diff = this.expireTime - item.expireTime;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}