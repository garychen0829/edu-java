package huawei;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main_HJ7 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double d = s.nextDouble();

        BigDecimal bigDecimal = new BigDecimal(d).setScale(0, RoundingMode.HALF_UP);
        System.out.println(bigDecimal);
    }
}
