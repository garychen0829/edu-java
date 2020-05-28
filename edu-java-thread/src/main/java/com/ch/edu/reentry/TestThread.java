package com.ch.edu.reentry;

public class TestThread {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.run();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}