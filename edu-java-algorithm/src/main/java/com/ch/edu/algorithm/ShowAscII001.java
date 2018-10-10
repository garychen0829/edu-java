package com.ch.edu.algorithm;

/**
 * 类描述：打印ascii码
 *
 * @author hui2.chen
 * @date 2018/9/6
 */
public class ShowAscII001 {

    public static void main(String[] args) {
        String temp = "";
        for (int i = 32; i <= 126; i++) {
            char c = (char) i;
            temp = i < 100 ? "0" + i : "" + i;
            System.out.print(temp + " = " + c + "\t");
            if ((i - 31) % 8 == 0) {
                System.out.println();
            }
        }
    }

}
