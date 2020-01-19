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
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trader{");
        sb.append("name='").append(name).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
