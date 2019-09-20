package com.jd.domain;

import java.util.List;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public class AreasInfo {

    private Object result;

    private List<Area> areaList;

    public Object getResult() {
        return result;
    }

    public AreasInfo setResult(Object result) {
        this.result = result;
        return this;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public AreasInfo setAreaList(List<Area> areaList) {
        this.areaList = areaList;
        return this;
    }
}

class Area {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public Area setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }
}
