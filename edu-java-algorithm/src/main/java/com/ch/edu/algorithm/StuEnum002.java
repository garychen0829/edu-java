package com.ch.edu.algorithm;

/**
 * 类描述：
 * 问题: 某学校毕业300人左右,毕业率为83.23%,求出最可能的学生人数, 左右表示上下20人.
 *
 * @author hui2.chen
 * @date 2018/9/6
 */
public class StuEnum002 {

    public static void main(String[] args) {
        StuEnum002 stu = new StuEnum002();
        stu.calcByEnum(300,20, 0.8323f);
    }

    /**
     * 计算
     *
     * @param iNum     人数
     * @param iOff     浮动数
     * @param fPercent 毕业比率
     */
    private void calcByEnum(int iNum, int iOff, float fPercent) {
        float fMinDiff = 1.0f, fTmp;
        int iRealNum = 300;
        for (int i = iNum - iOff + 1; i <= iNum + iOff; i++) {
            //abs 绝对值
            fTmp = Math.abs(Math.round(i * fPercent) / (float) i - fPercent);
            System.out.println(fTmp);
            if (fTmp < fMinDiff) {
                fMinDiff = fTmp;
                iRealNum = i;
            }
        }
        int iJiuYe = Math.round(iRealNum * fPercent);
        System.out.println("通过枚举,计算出学生总人数是: " + iRealNum);
        System.out.println("已就业学生人数: " + iJiuYe);
        System.out.println("问题陈述给出的就业率是:" + fPercent * 100 + "%");
        System.out.println("计算结果过对应的就业率是:" + (iJiuYe / (float) iRealNum) * 100 + "%");

    }
}
