package com.edu.java.demo1.service;

import com.edu.java.demo1.Person;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/11/12
 */
public class FilterPersonServiceImpl implements IFilterCond{

    private static final int FILTER_AGE_25 = Integer.parseInt("25");
    /**
     * 过滤大约25岁的人
     * @param person
     * @return
     */
    @Override
    public boolean test(Person person) {
        if (person.getAge() < FILTER_AGE_25) {
            return true;
        }
        return false;
    }
}
