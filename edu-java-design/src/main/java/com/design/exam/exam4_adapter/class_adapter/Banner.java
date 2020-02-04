package com.design.exam.exam4_adapter.class_adapter;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/10/10
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithA() {
        System.out.println("A_" + string + "_A");
    }

    public void showWithB() {
        System.out.println("B_" + string + "_B");
    }

}
