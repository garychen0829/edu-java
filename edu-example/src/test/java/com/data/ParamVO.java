package com.data;

public class ParamVO {
    private Integer value;
    private String name;

    public ParamVO() {}
    public ParamVO(String name, Integer value) {
        this.value = value;
        this.name = name;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
