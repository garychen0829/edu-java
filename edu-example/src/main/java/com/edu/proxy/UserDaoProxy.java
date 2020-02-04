package com.edu.proxy;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/20
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    protected UserDaoProxy(IUserDao target) {
        this.target = target;

    }

    @Override
    public int save() {
        System.out.println("开始事务...");
        try {
            target.save();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        System.out.println("结束事务...");
        return 1;
    }
}
