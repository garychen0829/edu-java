package com.design.exam.exam5_templateMethod.note;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/27
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractDisplay d1 = new ChartDisplay('O');
        AbstractDisplay d2 = new StringDisplay("Hello World");
        AbstractDisplay d3 = new StringDisplay("你好世界");

        d1.display();
        d2.display();
        d3.display();

    }
}
