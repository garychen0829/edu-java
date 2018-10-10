package com.design.exam.exam4_adapter.object_adapter;

import com.design.exam.exam4_adapter.class_adapter.Banner;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/10/10
 */
public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String string) {
        banner = new Banner(string);
    }

    @Override
    public void printA() {
        banner.showWithA();
    }

    @Override
    public void printB() {
        banner.showWithB();
    }
}
