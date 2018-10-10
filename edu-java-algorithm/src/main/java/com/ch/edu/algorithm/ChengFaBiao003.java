package com.ch.edu.algorithm;

/**
 * 类描述：九九乘法表
 *
 * @author hui2.chen
 * @date 2018/9/6
 */
public class ChengFaBiao003 {

    public static void main(String[] args) {
        System.out.println("九九乘法表");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }

}