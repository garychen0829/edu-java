package com.design.exam.exam2_chainOfResponseibility;

/**
 * Created by garychen on 2018/3/5.
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogger Logger: " + message);
    }
}
