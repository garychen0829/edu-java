package com.edu.java.test1;

import com.alibaba.fastjson.JSON;
import com.edu.java.test1.vo.Dish;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 􏿈流介绍
 * 从支持数据处理操作的源生成的元素序列
 *
 * @author hui2.chen
 * @date 2019/11/26
 */
public class TestStream {
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


    /**
     * 􏿕􏿖选出高热量的事务 > 300
     */
    @Test
    public void testHighCaloric() {
        menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .forEach(System.out::println);

        System.out.println("==========");

        List<String> list = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(d -> d.getName())
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void testGroupByType() {
        Map<Dish.Type, Set<String>> collect = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toSet())));

        System.out.println(JSON.toJSONString(collect));

    }

    /**
     * 分组, 排序
     */
    @Test
    public void testGroupByTypeReturnMap() {
        HashMap<Boolean, List<String>> collect = menu.stream()
                .sorted(Comparator.comparing(Dish::getName))
                .collect(Collectors.groupingBy(Dish::isVegetarian, HashMap::new, Collectors.mapping(Dish::getName, Collectors.toList())));

        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void testIsVegetarian() {
        List<Dish> collect = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void testNum_distinct_filter_skip_limit() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 8, 6, 4, 5, 6, 7, 8, 9);

        List<Integer> collect = numbers.stream()
                .distinct()
                .filter(i -> i % 2 == 0)
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void test_Count_length() {
        List<Integer> collect = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void test_Max_length() {
//        menu.stream()
//                .map(Dish::getName)
//                .map(String::length)
//                .max((o1,o2)->Comparator.comparingInt(o1,o2));
//        System.out.println(JSON.toJSONString(collect));
    }
}
