package com.edu.java.exam2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * 原始类型流特化
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/11/16
 */
public class ExamStream2 {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );

        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        //分解练习上面的例子
        System.out.println("==============================");
        System.out.println("打印100以内的偶数: ");
        IntStream evenNumber =
                IntStream.rangeClosed(1, 100)
                    .filter(x -> x % 2 == 0);
        System.out.println(evenNumber.count());

        System.out.println("==============================");
        System.out.println("boxed() ==> 将数值转为Stream流");

        Stream<Integer> integerStream =
                IntStream.rangeClosed(1, 100)
                        .filter(x -> x % 2 == 0).boxed();
        System.out.println(integerStream.count());

        //筛选成立的组合 a*a + b*b = c*c
        //filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)

    }
}
