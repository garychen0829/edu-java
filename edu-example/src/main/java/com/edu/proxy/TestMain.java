package com.edu.proxy;

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
        IUserDao iUserDao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(iUserDao);
        proxy.save();
    }
}
