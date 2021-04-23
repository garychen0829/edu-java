package com.test;

public class ParamDoubleVO {
    private Double value = 0.00d;
    private String name;

    public ParamDoubleVO() {}

    public ParamDoubleVO(String name, Double value) {
        this.value = value;
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
