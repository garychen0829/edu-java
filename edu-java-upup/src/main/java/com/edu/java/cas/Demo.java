package com.edu.java.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Demo {

    /**
     * 总访问量
     */
    static int count = 0;

    /**
     * 用户请方法 synchronized
     */
    public synchronized static void request() throws InterruptedException {
        //模拟耗时5s
        TimeUnit.MILLISECONDS.sleep(5);
        count++;
    }

//    /**
//     * 用户请方法
//     */
//    public static void request() throws InterruptedException {
//        //模拟耗时5s
//        TimeUnit.MILLISECONDS.sleep(5);
//        count++;
//    }

    public static void main(String[] args) throws InterruptedException {
        //开始时间
        long startTime = System.currentTimeMillis();
        int threadSize = 100;

        //保证100个线程结束之后，再执行后面的代码
        final CountDownLatch latch = new CountDownLatch(threadSize);

        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //模拟用户行为，每个用户访问10次
                    try {
                        for (int j = 0; j < 10; j++) {
                            request();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }

                }
            });
            thread.start();
        }

        latch.await();
        long endTime = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName() + ",耗时： " + (endTime - startTime) + "count=" + count);
    }

}
