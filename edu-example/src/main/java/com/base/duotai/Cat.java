package com.base.duotai;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/7/23
 */
public class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("吃鱼");
    }

    public boolean work(){
        System.out.println("抓老鼠");
        return false;
    }

    @Override
    public boolean suport(String cmd) {
        if ("咪咪".equals(cmd)) {
            Cat c = new Cat();
            boolean b = c.work();
            if (b) {
                System.out.println("干好了");
                return true;
            }
            System.out.println("没干好. 没干好就别想吃了");
            return false;
        }
        return false;
    }
}
