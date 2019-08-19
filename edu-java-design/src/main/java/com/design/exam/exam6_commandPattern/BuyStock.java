package com.design.exam.exam6_commandPattern;

/**
 * 创建实现了 Order 接口的实体类。
 * BuyStock
 * SellStock
 */
public class BuyStock implements Order {
   private Stock abcStock;
 
   public BuyStock(Stock abcStock){
      this.abcStock = abcStock;
   }

    @Override
    public void execute() {
        abcStock.buy();
    }
}