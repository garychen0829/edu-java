package com.design.exam.exam4_adapter.class_adapter.main;

import com.design.exam.exam4_adapter.class_adapter.Print;
import com.design.exam.exam4_adapter.class_adapter.PrintBanner;

/**
 * 类描述：使用继承适配器模式
 *
 * @author hui2.chen
 * @date 2018/10/10
 */
public class TestMain {
    public static void main(String[] args) {
        Print print = new PrintBanner("hello");
        print.printA();
        print.printB();
    }
}
