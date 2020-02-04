package com.base.duotai;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/7/23
 */
public class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("吃骨头");
    }

    public void work() {
        System.out.println("看门");

    }


    @Override
    public boolean suport(String cmd) {
        if ("旺旺".equals(cmd)) {
            Dog c = new Dog();
            c.work();
            return true;
        }
        return false;
    }
}
