package com.edu.java.demo4.producer;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/12
 */
public class OrderMessage {
    private int id;
    private String status;
    private int sendOrder;
    private String content;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderMessage{");
        sb.append("id=").append(id);
        sb.append(", status='").append(status).append('\'');
        sb.append(", sendOrder=").append(sendOrder);
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSendOrder() {
        return sendOrder;
    }

    public void setSendOrder(int sendOrder) {
        this.sendOrder = sendOrder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
