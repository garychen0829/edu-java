import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/5/8
 */
public class TestMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int no = 0; no <= 1004; no++) {
            list.add(no);
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                continue;
            }
//            if (i % 500 == 0 || i == list.size() -1) {
//                System.out.println("ok=>"+ (i+1));
//            }

            if (i % 500 == 0 || i+1 == list.size()) {
                System.out.println("ok2=>"+ (i+1));
            }
        }

    }
}
