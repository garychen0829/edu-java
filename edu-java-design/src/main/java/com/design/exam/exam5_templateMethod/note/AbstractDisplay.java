package com.design.exam.exam5_templateMethod.note;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/6
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display(){
        open();
        for (int i = 0; i <= 5; i++) {
            print();
        }
        close();
    }

}
