package com.base.duotai;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 面向对象 多态的思想理解
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/7/23
 */
public class TestAnimal {
    //模拟初始化加载集合信息
    public static List<Animal> list = new ArrayList<>();

    static {
        Animal dog  = new Dog();
        Animal cat  = new Cat();
        list.add(dog);
        list.add(cat);
    }

    public static void main(String[] args) {
        TestAnimal animal = new TestAnimal();
//        animal.invoke("咪咪");
//        animal.invoke("咪咪");



        animal.invoke1();
//        animal.invoke("咪咪");
    }

    //主人叫干活了1
    public void invoke1() {
        for (Animal animal : list) {
            if (animal.suport("咪咪")) {
                animal.eat();
            }
        }
    }

    //主人叫干活了
    public void invoke(String cmd) {
        Animal cat  = new Cat();
        Animal dog  = new Dog();
        if ("咪咪".equals(cmd)) {
            ((Dog) dog).work();
        }
        if ("咪咪".equals(cmd)) {
            ((Cat) cat).work();
        }

    }
}
