package com.ch.edu.thread;

public class SyncUnSafeDemoMain {

//    public static void main(String[] args)  {
//        final SyncDemo syncDemo = new SyncDemo();
//
//        Thread first = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    syncDemo.thradUnSafe("key");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        first.setName("first");
//        first.start();
//
//
//        final Thread second = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    syncDemo.thradUnSafe("a");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        second.setName("second");
//        second.start();
//    }

    public static void main(String[] args)  {
        final SyncDemo syncDemo1 = new SyncDemo();
        final SyncDemo syncDemo2 = new SyncDemo();

        Thread first = new Thread(new Runnable() {
            public void run() {
                try {
                    syncDemo1.thradUnSafe("key");
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
                    syncDemo2.thradUnSafe("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        second.setName("second");
        second.start();
    }

}
