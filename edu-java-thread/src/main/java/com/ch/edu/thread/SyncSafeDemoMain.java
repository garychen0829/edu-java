package com.ch.edu.thread;

public class SyncSafeDemoMain {
    public static void main(String[] args)  {
        final SyncDemo syncDemo = new SyncDemo();

        Thread first = new Thread(new Runnable() {
            public void run() {
                try {
                    syncDemo.thradSafe("key");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        first.setName("first");
        first.start();


        final Thread second = new Thread(new Runnable() {
            public void run() {
                try {
                    syncDemo.thradSafe("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        second.setName("second");
        second.start();
    }
}
