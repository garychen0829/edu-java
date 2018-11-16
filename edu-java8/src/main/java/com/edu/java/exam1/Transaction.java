package com.edu.java.exam1;

/**
 * <pre>
 * serviceGroup = ServiceGroups.(这里拷贝对应的值)
 * (这里用一句话描述这个接口的作用)
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/11/16
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Transaction{");
        sb.append("trader=").append(trader);
        sb.append(", year=").append(year);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}
