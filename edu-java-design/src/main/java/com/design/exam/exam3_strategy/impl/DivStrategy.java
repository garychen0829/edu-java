package com.design.exam.exam3_strategy.impl;

import com.design.exam.exam3_strategy.IStrategy;

/**
 * Created by garychen on 2018/4/9.
 */
public class DivStrategy implements IStrategy {
    @Override
    public int execute(int n, int m) {
        System.out.println(n + " / " + m + " = " + (n / m));
        return n / m;
    }
}
