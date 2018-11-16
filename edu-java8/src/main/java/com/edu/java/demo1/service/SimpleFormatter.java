package com.edu.java.demo1.service;

import com.edu.java.demo1.Person;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/11/12
 */
public class SimpleFormatter implements IFormatter {
    @Override
    public String accept(Person person) {
        return person.getName() + "是个好人";
    }
}
