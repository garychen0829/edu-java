package com.design.exam.exam6_commandPattern;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/8
 */
public class CommandPatternDemo {

    public static void main(String[] args) {

        Stock stock = new Stock();
        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }
}
