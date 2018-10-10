package com.ch.edu.algorithm;


import com.ch.edu.algorithm.stack.DATA3;
import com.ch.edu.algorithm.stack.StackType;

import java.util.Scanner;

/**
 * 类描述：栈结构
 * (后进先出 Last In Frist Out, LIFO)
 *
 * @author hui2.chen
 * @date 2018/9/11
 */
public class Stack004_LIFO_TestMain {
    static final int MAXLEN = 50;

    public static void main(String[] args) {
        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        StackType stack = st.STInit();
        Scanner input = new Scanner(System.in);
        System.out.println("入栈操作,输入0 结束入栈操作: \n");
        System.out.println("请输入姓名, 年龄进行入栈操作:");
        do {
            DATA3 data = new DATA3();
            data.name = input.next();

            if (data.name.equals("0")) {
                break;
            } else {
                data.age = input.nextInt();
                st.PushST(stack, data);
            }
        } while (true);

        String temp = "1";
        System.out.println("出栈操作: 按任意非0键进行出栈操作:");
        temp = input.next();
        while (!temp.equals(0)) {
            data1 = st.PopST(stack);
            System.out.printf("出栈的数据是(%s, %d)\n", data1.name, data1.age);
            temp = input.next();
        }
        System.out.println("测试结束");
        st.STFree(st);
    }
}