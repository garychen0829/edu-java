package com.design.demo.demo1;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/5
 */
public class MessageBody {
    Object payload;

    public void configure(Object payload) {
        this.payload = payload;
    }

    public void send(MessageStrategy messageStrategy) {
        messageStrategy.sendMessage();
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
