package com.edu.java.demo1;

import com.alibaba.fastjson.JSONObject;
import com.edu.java.demo1.service.FilterPersonServiceImpl;
import com.edu.java.demo1.service.IFilterCond;
import com.edu.java.demo1.service.SimpleFormatter;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/11/12
 */
public class Demo01 {
    public static void main(String[] args) {
        Person p1 = new Person("张三",23);
        Person p2 = new Person("李四",24);
        Person p3 = new Person("王五",25);
        Person p4 = new Person("赵六",26);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);


        Person pa = new Person("张三a",23);
        Person pb = new Person("李四b",24);
        Person pc = new Person("王五c",25);
        Person pd = new Person("赵六d",26);

        List<Person> peopleEn = new ArrayList<>();
        peopleEn.add(pa);
        peopleEn.add(pb);
        peopleEn.add(pc);
        peopleEn.add(pd);

        Map<String, List<Person>> listMap = new HashMap<>();
        listMap.put("1",people);
        listMap.put("2",peopleEn);


        //筛选people集合中的数据
        //方法一
        // for (int ....) {
        //     if () {
        //         .....
        //     }
        // }


        //方法二
        //写个接口,通过接口的实现来判断
        List<Person> list = filterPerson(people, new FilterPersonServiceImpl());
        System.out.println(">>>" + list.size());

        //方法三 匿名类
        List<Person> list2 = filterPerson(people, new IFilterCond() {
            @Override
            public boolean test(Person person) {
                return person.getName().equals("张三");
            }
        });
        System.out.println("###" + list2.size());

        filterPerson2(people, new SimpleFormatter());

        //方法四 Lambda表达式
        filterPerson(people, (Person p)-> "张三".equals(p.getName()));


        //五: 真实的例子 Runnable()
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello Thread.");
//            }
//        });
//        t.start();

        //
        Thread t = new Thread(()-> System.out.println("hello runnable ."));
        t.start();
        //由此-> 引入Lambda表达式的引入...

        Comparator<Person> comparatorAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        //stream 初探.
        List<String> names = people.stream()
                .filter(p->p.getAge()<25)
                .sorted(comparing(Person::getAge))
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(names.toArray()));

        //利用多核架构并行执行这段代码,只需要把stream()换成parallelStream().
        List<String> names2 = people.parallelStream()
                .filter(p->p.getAge()<25)
                .sorted(comparing(Person::getAge))
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(names2.toArray()));
    }

    private static void filterPerson2(List<Person> people, SimpleFormatter simpleFormatter) {
        for (Person person : people) {

            System.out.println(simpleFormatter.accept(person));
        }

    }

    /**
     * 方法二
     * @param people
     * @param iFilterCond
     * @return
     */
    public static List<Person> filterPerson(List<Person> people, IFilterCond iFilterCond){
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (iFilterCond.test(person)){
                result.add(person);
            }
        }
        return result;
    }
}
