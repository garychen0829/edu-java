package com.design.demo.demo1;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/5
 */
public class DefaultFactory extends AbstractStategyFactory {
    private DefaultFactory() {
    }

    static DefaultFactory instance;

    public static AbstractStategyFactory getInstance() {
        if (null == instance) {
            instance = new DefaultFactory();
        }
        return instance;
    }

    @Override
    public MessageStrategy createStategy(final MessageBody mb) {
        return new MessageStrategy() {
            MessageBody body = mb;

            @Override
            public void sendMessage() {
                Object obj = body.getPayload();
                System.out.println(obj);
            }
        };
    }
}
