package com.edu.proxy2;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/20
 */
public class Target implements TargetInterface {
    @Override
    public void method1() {
        System.out.println("方法1");
    }

    @Override
    public String method2() {
        System.out.println("方法2");
        return "method2";
    }

    @Override
    public int method3(int x) {
        System.out.println("方法3");
        return x;
    }
}
