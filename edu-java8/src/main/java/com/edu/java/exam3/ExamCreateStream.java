package com.edu.java.exam3;

import com.edu.java.demo2.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;

/**
 * <pre>
 * 构建流
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/11/16
 */
public class ExamCreateStream {
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

    public static void main(String[] args) {
        //由值创建流
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        System.out.println("============================");

        //由数组创建流
        int[] numbers = {2, 3, 5, 7, 11, 13};
        IntStream num = Arrays.stream(numbers);
        int count = num.sum();
        System.out.println(count);

        System.out.println("============================");

        //由文件生成流
        long uniqueWords = 0;
        try {
            Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        System.out.println("============================");

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("============================");

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(30)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(30)
                .map(t -> t[0])
                .forEach(System.out::print);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("============================");

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);

    }
}