package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ASCII码范围内(0~127，包括0和127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述：
 * 输入一行没有空格的字符串。
 *
 * 输出描述：
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 */
public class Main_HJ10 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        char[] chars = line.toCharArray();
        Set set = new HashSet<>();
        for (char c : chars) {
            //System.out.println((int)c);
            set.add(c);
        }
        System.out.println(set.size());
    }
}
