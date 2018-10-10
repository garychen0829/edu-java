package com.ch.edu.algorithm.stack;

public class StackType {
    static final int MAXLEN = 50;
    DATA3[] data = new DATA3[MAXLEN + 1];
    int top;


    /**
     * 初始化顺序栈
     *
     * @return
     */
    public StackType STInit() {
        StackType p;
        if ((p = new StackType()) != null) {
            p.top = 0;
            return p;
        }
        return null;
    }

    /**
     * 判断是否为空
     *
     * @param s
     * @return
     */
    public boolean STIsEmpty(StackType s) {
        boolean t;
        t = (s.top == 0);
        return t;
    }

    /**
     * 清空栈
     *
     * @param s
     */
    public void STClear(StackType s) {
        s.top = 0;
    }

    /**
     * 释放栈所占用的空间
     */
    public void STFree(StackType s) {
        if (s != null) {
            s = null;
        }
    }

    /**
     * 入栈
     *
     * @param s
     * @param data
     * @return
     */
    public int PushST(StackType s, DATA3 data) {
        if ((s.top + 1) > MAXLEN) {
            System.out.println("栈溢出!\n");
            return 0;
        }
        s.data[++s.top] = data;
        return 1;
    }

    /**
     * 出栈
     *
     * @param s
     * @return
     */
    public DATA3 PopST(StackType s) {
        if (s.top == 0) {
            System.out.println("栈为空\n");
            System.exit(0);
        }
        return (s.data[s.top--]);
    }

    /**
     * @param s
     * @return
     */
    public DATA3 PeekST(StackType s) {
        if (s.top == 0) {
            System.out.println("栈为空\n");
            System.exit(0);
        }
        return (s.data[s.top]);
    }
}