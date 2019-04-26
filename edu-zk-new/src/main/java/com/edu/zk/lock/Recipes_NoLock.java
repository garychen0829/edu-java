package com.edu.zk.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/4/10
 */
public class Recipes_NoLock {

    /**
     * 一个典型时间戳生成的并发问题
     * @param args
     */
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i< 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    System.out.println("生成的订单号:" + orderNo);
                }
            }).start();
        }
        latch.countDown();

    }
}
