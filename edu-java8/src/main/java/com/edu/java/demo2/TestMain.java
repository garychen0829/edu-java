package com.edu.java.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述：stream (流)
 *
 * @author hui2.chen
 * @date 2018/11/15
 */
public class TestMain {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //流到底是什么呢?简短的定义就是“从支持数据处理操作的源生成的元素序列”
        //元素序列

        List<String> threeHighCaloricDishNames =
        menu.stream()
                .filter(d->d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);


        long count = menu.stream()
                .filter(d->d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);
    }
}
