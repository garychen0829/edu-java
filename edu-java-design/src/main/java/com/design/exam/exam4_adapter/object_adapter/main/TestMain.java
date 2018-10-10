package com.design.exam.exam4_adapter.object_adapter.main;

import com.design.exam.exam4_adapter.object_adapter.PrintBanner;

/**
 * 类描述：使用委托适配器模式
 *
 * @author hui2.chen
 * @date 2018/10/10
 */
public class TestMain {
    public static void main(String[] args) {
        PrintBanner printBanner = new PrintBanner("say");
        printBanner.printA();
        printBanner.printB();

    }
}
