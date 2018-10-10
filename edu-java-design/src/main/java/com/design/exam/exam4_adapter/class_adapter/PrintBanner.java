package com.design.exam.exam4_adapter.class_adapter;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/10/10
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printA() {
        super.showWithA();
    }

    @Override
    public void printB() {
        super.showWithB();
    }
}
