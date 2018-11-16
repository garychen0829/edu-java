package com.edu.java.exam1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * <pre>
 * 练习 java8 Stream()的相关方法
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/11/16
 */
public class ExamStreamFunction {
    /**
     * (1)找出2011年发生的所有交易, 并按交易额排序(从低到高)
     * (2)
     */

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        System.out.println("===============================================");
        System.out.println("(1)找出2011年发生的所有交易, 并按交易额排序(从低到高)");

        List<Transaction> t1 =
                transactions.stream()
                        .filter(x -> x.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(Collectors.toList());

        t1.stream().forEach(System.out::println);

        System.out.println("===============================================");
        System.out.println("(2)交易员都在哪些不同的城市工作过");

        List<String> t2 =
                transactions.stream()
                        .map(x -> x.getTrader().getCity())
                        .distinct()
                        .collect(Collectors.toList());

        t2.stream().forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        Set<String> s2 =
                transactions.stream()
                        .map(x -> x.getTrader().getCity())
                        .collect(Collectors.toSet());

        s2.stream().forEach(System.out::println);

        System.out.println("===============================================");
        System.out.println("(3)查询所有来剑桥的交易员, 并按姓名排序");

        List<Trader> t3 =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(x -> x.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(Collectors.toList());

        t3.stream().forEach(System.out::println);

        System.out.println("===============================================");
        System.out.println("(4)返回所有交易员的姓名字符串, 按字母顺序排序");

        String s4 =
                transactions.stream()
                        .map(x -> x.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (a1, b1) -> a1 + b1);
        System.out.println(s4);

        String j4 =
                transactions.stream()
                        .map(x -> x.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining());

        System.out.println(j4);

        System.out.println("===============================================");
        System.out.println("(5)有没有交易员是在米兰工作的");

        Boolean flag =
                transactions.stream()
                        .anyMatch(x -> x.getTrader().getCity().equals("Milan"));

        System.out.println(flag);

        System.out.println("===============================================");
        System.out.println("(6)打印生活在剑桥的交易员的所有交易金额");


        transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getValue())
                .forEach(System.out::println);

        System.out.println("===============================================");
        System.out.println("(7)交易中交易金额最高的");

        Optional<Integer> t7 =
                transactions.stream()
                        .map(x->x.getValue())
                        .reduce(Integer::max);
        System.out.println(t7.get());

        System.out.println("===============================================");
        System.out.println("(8)交易中交易金额最小的");
        Optional<Integer> t8 =
                transactions.stream()
                        .map(x->x.getValue())
                        .reduce(Integer::min);
        System.out.println(t8.get());

        Optional<Transaction> t9 =
                transactions.stream().min(comparing(Transaction::getValue));
        System.out.println(t9.get());

    }
}
