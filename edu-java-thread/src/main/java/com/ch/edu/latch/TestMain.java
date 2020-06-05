package com.ch.edu.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestMain {

    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {

        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
            System.out.println(5);
        }).start();


        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
            System.out.println("2");
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
//        try {
//            boolean bool = latch.await(4000, TimeUnit.MILLISECONDS);
//            System.out.println(bool);
//            if (!bool) {
//                System.out.println("4s");
//                return;
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
