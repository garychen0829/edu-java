package com.edu.zk.lock;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 使用 Curator 实现分布式锁功能
 *
 * @author hui2.chen
 * @date 2019/4/10
 */
public class Recipes_Lock {

    /**
     * 1. 启动本机zk服务; sh bin/zkServer.sh start
     * 2. 打开本机客户端; sh bin/zkCli.sh -server 127.0.0.1:2181
     *
     * @param args
     */
    public static final String lock_path = "/curator_recipes_lock_path";
    public static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000, 2)).build();

    public static void main(String[] args) {
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client, lock_path);
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    down.await();
                    lock.acquire();

                } catch (Exception e) {
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.out.println("生成的订单号是:" + orderNo);

                try {
                    lock.release();
                } catch (Exception e) {
                }
            }).start();
        }
        down.countDown();
        System.out.println("Go");

    }
}
