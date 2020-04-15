package com.queue.delay;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class DelayedItem implements Delayed {

    /**
     * 触发时间
     */
    private long time;
    private String name;
    private ITestInvoke invoke;

    public DelayedItem(String name, ITestInvoke invoke, long time, TimeUnit unit) {
        this.name = name;
        this.invoke = invoke;
        this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
    }

    /**
     * 获得延迟时间   用过期时间-当前时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    /**
     * 用于延迟队列内部比较排序   当前时间的延迟时间 - 比较对象的延迟时间
     *
     * @param delayed
     * @return
     */
    @Override
    public int compareTo(Delayed delayed) {
        DelayedItem item = (DelayedItem) delayed;
        long diff = this.time - item.time;
        if (diff <= 0) {
            return -1;
        }else {
            return 1;
        }
    }
}
