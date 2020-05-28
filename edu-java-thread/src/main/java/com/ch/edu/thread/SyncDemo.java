package com.ch.edu.thread;

public class SyncDemo {

    /**
     * 线程安全
     */
    public void thradSafe(String key) throws InterruptedException {
        int no = 0;
        if ("key".equals(key)) {
            no = 100;
            System.out.println("eq key=" + no);
            Thread.sleep(1000);
        } else {
            no = 200;
            System.out.println("ne key=" + no);
        }
        System.out.println("key=" + key + " no=" + no);
    }


    /**
     * 非线程安全
     */
    int no = 0;
    public void thradUnSafe(String key) throws InterruptedException {
        if ("key".equals(key)) {
            no = 100;
            System.out.println("key=" + no);
            Thread.sleep(1000);
        } else {
            no = 200;
            System.out.println("ne key" + no);
        }
        System.out.println("key=" + key + " no=" + no);
    }
}
