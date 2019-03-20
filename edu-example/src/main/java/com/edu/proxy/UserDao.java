package com.edu.proxy;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/20
 */
public class UserDao implements IUserDao {

    @Override
    public int save() {
        System.out.println("--- 已经保存数据 ---");
        return 0;
    }
}
