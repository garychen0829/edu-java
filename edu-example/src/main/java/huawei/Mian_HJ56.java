package huawei;

import java.util.Scanner;

public class Mian_HJ56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int count = 0;
            for (int i = 0; i<num; i++){
                if ((num % 2) == 0 || (num % 3) == 0 || (num % 5) == 0 || (num % 7) == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
