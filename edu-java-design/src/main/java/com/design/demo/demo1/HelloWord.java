package com.design.demo.demo1;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/5
 */
public class HelloWord {
    public static void main(String[] args) {
        MessageBody mb = new MessageBody();
        mb.configure("hello world..");
        AbstractStategyFactory asf = DefaultFactory.getInstance();
        MessageStrategy strategy = asf.createStategy(mb);
        mb.send(strategy);
    }
}
