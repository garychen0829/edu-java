package com.jd.domain;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public class AreaRequest {
    private String type;
    private String parentId;

    public String getType() {
        return type;
    }

    public AreaRequest setType(String type) {
        this.type = type;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public AreaRequest setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
}
