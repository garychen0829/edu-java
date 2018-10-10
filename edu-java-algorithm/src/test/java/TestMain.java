/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/9/19
 */
public class TestMain {

    public static void main(String[] args) {
        String value = "玩儿";
        System.out.println(value.getBytes().length);
        //左补空格
        System.out.println(String.format("%1$-20s",value));


        value  = value.replaceAll("儿",null);
        System.out.println(value);
    }
}