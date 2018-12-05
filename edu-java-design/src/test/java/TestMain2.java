/**
 * <pre>
 * serviceGroup = ServiceGroups.(这里拷贝对应的值)
 * (这里用一句话描述这个接口的作用)
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/11/23
 */
public class TestMain2 {
    public static void main(String[] args) {
        String ss = "你有一条消息-商品申请消息{storeName} - {goodsApplyNameJp}<a href='goodsApply/editInit?id=45&storeId=20180627000010ST00000012'>view</a>";
        ss = ss.replace("{storeName}","aaaa");
        System.out.println(ss);
    }
}
