package com.edu.proxy_cglib;

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
        UserDao target = new UserDao();
        UserDao userDao = (UserDao) new ProxyFactory(target).getProxyInstance();
        userDao.save();

    }
}
