package com.edu.proxy2;

import com.edu.proxy.IUserDao;
import com.edu.proxy.UserDao;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/20
 */
public class TestMain {
    public static void main(String[] args) {
        Target target = new Target();

        System.out.println(target.getClass());

        TargetInterface proxy = (TargetInterface) new ProxyFactory(target).getProxyInstance();

        System.out.println(proxy.getClass());

        proxy.method1();
        proxy.method2();
        proxy.method3(4);
    }
}
