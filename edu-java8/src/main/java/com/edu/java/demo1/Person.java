package com.edu.java.demo1;

import lombok.Data;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/11/12
 */
@Data
public class Person {

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;


}
