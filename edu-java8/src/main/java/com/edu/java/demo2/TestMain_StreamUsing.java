package com.edu.java.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * serviceGroup = ServiceGroups.(这里拷贝对应的值)
 * (这里用一句话描述这个接口的作用)
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/11/15
 */
public class TestMain_StreamUsing {
    public static List<Dish> menu = Arrays.asList(
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
     * 选、切 和匹配
     * 查找、匹配和归约
     * 使用数值范围等数值流   从多个源创建流
     * 无限流
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-------------------");
        List<Dish> list1 = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("-------------------");
        List<Dish> list2 = menu.stream()
                .filter(Dish::isVegetarian)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("-------------------");
        menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------------");
        menu.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------------");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(x -> x % 2 == 1)
                .distinct()
                .forEach(System.out::println);

        System.out.println("-------------------");


        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        words.stream()
                .map(String::length)
                .forEach(System.out::println);

        System.out.println("-------------------");

        List<Integer> items =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .map(Dish::getName)
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println(items);
        System.out.println("-------------------");

        String[] strs = new String[]{"Hello", "World"};
        List<String> items2 = Arrays.asList(strs);
        items2.stream()
                .map(x -> x.split(""))
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        items2.stream()
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===================");

        items2.stream()
                .map(x -> x.split(""))
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("===================");

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        numbers2.stream()
                .map(x -> x * x)
                .forEach(System.out::println);
        System.out.println("===================");

        List<Integer> numbersA = Arrays.asList(1, 2, 3);
        List<Integer> numbersB = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbersA.stream()
                        .flatMap(i -> numbersB.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(Collectors.toList());
        System.out.println(pairs);

        System.out.println("===================");

        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!");
        }

        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy);

        System.out.println("===================");

        Optional<Dish> o = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        System.out.println(o);

        o = menu.stream()
                .filter(d -> d.getName().equals("aaa"))
                .findAny();

        System.out.println(o.isPresent());
        System.out.println("===================");

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findAny(); // 9

        System.out.println(firstSquareDivisibleByThree);

        System.out.println("===================");

        Integer sum = someNumbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Integer sum1 = someNumbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("乘法: " + sum1);

        Optional<Integer> max1 = someNumbers.stream().reduce(Integer::max);
        System.out.println(max1);

        Optional<Integer> min1 = someNumbers.stream().reduce(Integer::min);
        System.out.println(min1);

        int count = menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(count);


    }
}
