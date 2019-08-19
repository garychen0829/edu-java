package com.design.exam.exam6_commandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 创建命令调用类。
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/8
 */
public class Broker {

    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();

        }
        orderList.clear();
    }

}
