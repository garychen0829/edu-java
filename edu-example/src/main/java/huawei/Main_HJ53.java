package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ53 杨辉三角变形
 */
public class Main_HJ53 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == 1 || num == 2) {
                System.out.println(-1);
                continue;
            } else if (num % 4 == 1 || num % 4 == 3) {
                System.out.println(2);
                continue;
            } else if (num % 4 == 0) {
                System.out.println(3);
                continue;
            } else if (num % 4 == 2) {
                System.out.println(4);
                continue;
            }
//        Scanner in = new Scanner(System.in);
//        method1(in.nextInt());
//        method2(in.nextInt());
        }
    }

    public static void method1(int rows) {
        for (int i = 0; i < rows; i++) {
            int number = 1;
            //打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void method2(int rows) {
        for (int i = 0; i < rows; i++) {
            List<String> res = new ArrayList<>(i + 1);
            long nk = 1;
            for (int n = 0; n <= i; n++) {
                res.add(String.valueOf(nk));
                nk = nk * (i - n) / (n + 1);
            }
            System.out.format("%" + (rows - i) + "s%s\n", " ", String.join(" ", res));
        }

    }

}
