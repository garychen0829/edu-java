package com.design.demo.demo1;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/5
 */
public abstract class AbstractStategyFactory {
    public abstract MessageStrategy createStategy(MessageBody messageBody);
}
