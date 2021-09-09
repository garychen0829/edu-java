package huawei;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        Map<Integer, Integer> map = new HashMap<>(size);

        Scanner kv = new Scanner(System.in);
        int i = 0;
        while (kv.hasNextLine()) {
            String str = kv.nextLine();
            String[] arr = str.split(" ");
            if (map.containsKey(Integer.parseInt(arr[0])) == false) {
                map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            } else {
                BigDecimal countNum = new BigDecimal(map.get(Integer.parseInt(arr[0]))).add(new BigDecimal(arr[1]));
                map.put(Integer.parseInt(arr[0]), countNum.intValue());
            }
            i++;
            if (i == size) {
                break;
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> result : entries) {
            System.out.println(result.getKey() + " " + result.getValue());

        }

    }
}
