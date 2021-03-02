package com.ch.edu.ladder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LadderTest {

    public static void main(String[] args) {
        List<LadderTmp> list = new LinkedList<>();
        LadderTmp atmp = new LadderTmp();
        atmp.setStart(1);
        atmp.setEnd(100);
        atmp.setPrice(2);

        LadderTmp btmp = new LadderTmp();
        btmp.setStart(101);
        btmp.setEnd(200);
        btmp.setPrice(5);

        LadderTmp ctmp = new LadderTmp();
        ctmp.setStart(201);
        ctmp.setEnd(500);
        ctmp.setPrice(8);

        LadderTmp dtmp = new LadderTmp();
        dtmp.setStart(501);
        dtmp.setEnd(99999999);
        dtmp.setPrice(9);

        list.add(atmp);
        list.add(btmp);
        list.add(ctmp);
        list.add(dtmp);

        int num = 4000;
        // 阶梯价计费方式 1000 => (1000-(1000-100))*2 + (900-(900-101))*5+ ...
        for (LadderTmp tmp : list) {
            System.out.println(((tmp.getEnd() - tmp.getStart()) + 1) * tmp.getPrice());
            //System.out.println((num - ((tmp.getEnd() - tmp.getStart()) + 1)) * tmp.getPrice());
        }


    }
}
