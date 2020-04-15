package com.queue.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    public static void main(String[] args) throws Exception {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        System.out.println("开始任务");
        //延时3秒执行,每1秒执行一次
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                System.out.println("执行任务");
            }
        }, 3, 2, TimeUnit.SECONDS);

    }

}
