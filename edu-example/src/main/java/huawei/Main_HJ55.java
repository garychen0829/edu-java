package huawei;

import java.util.*;

/**
 * 输出关于7 的数据
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 */
public class Main_HJ55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        for (int i = in.nextInt(); i > 0; i--) {
            if (i % 7 == 0 || (i + "").contains("7")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
