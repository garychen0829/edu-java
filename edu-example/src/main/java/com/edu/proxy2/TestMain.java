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
        IUserDao target = new UserDao();

        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();

        System.out.println(proxy.getClass());

        proxy.save();
    }
}
