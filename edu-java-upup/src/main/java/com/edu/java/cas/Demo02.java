package com.edu.java.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 解决 synchronized 耗时问题
 */
public class Demo02 {

    /**
     * 总访问量
     */
    volatile static int count = 0;

    /**
     * 用户请方法 synchronized
     */
    public static void request() throws InterruptedException {
        //模拟耗时5s
        TimeUnit.MILLISECONDS.sleep(5);

        int exceptCount;
        while (!compareAndSwap(exceptCount = getCount(), exceptCount + 1)) {}
    }

    /**
     * cas
     *
     * @param exceptCount 期望值
     * @param newCount    需要给count赋值的新值
     * @return
     */
    public static synchronized boolean compareAndSwap(int exceptCount, int newCount) {
        //判断 count 当前值是否与期望值 exceptCount一致,如果一致,则将 newCount赋值给 count
        if (getCount() == exceptCount) {
            count = newCount;
            return true;
        }
        return false;
    }

    public static int getCount() {
        return count;
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

        System.out.println(Thread.currentThread().getName() + ",耗时： " + (endTime - startTime) + ",count=" + count);
    }

}
