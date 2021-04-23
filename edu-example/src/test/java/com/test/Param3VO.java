package com.test;

import lombok.Data;

@Data
public class Param3VO {

    private String roadName;
    private String name;
    private Integer value;

    public Param3VO(){}

    public Param3VO(String roadName, String name, Integer value) {
        this.roadName = roadName;
        this.name = name;
        this.value = value;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
