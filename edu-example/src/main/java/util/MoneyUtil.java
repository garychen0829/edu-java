package util;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 金额工具类
 */
public final class MoneyUtil {

    /**
     * 将对象里面的props字段进行分转元处理，包括子类
     *
     * @param os
     * @param props
     * @param <T>
     * @return
     */
    public static final <T> List<Map<String, Object>> fenToYuan(List<T> os, String... props) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (T t : os) {
            result.add(fenToYuan(t, props));
        }
        // 返回结果
        return result;
    }

    /**
     * 将对象里面的props字段进行分转元处理，包括子类
     *
     * @param o
     * @param props
     * @return
     */
    @SuppressWarnings("unchecked")
    public static final Map<String, Object> fenToYuan(Object o, String... props) {
        String json = JSONObject.toJSONString(o);
        Map<String, Object> map = JSONObject.parseObject(json, Map.class);
        // 分转元处理
        fenToYuan(map, props);
        // 返回结果
        return map;
    }

    /**
     * 将map里面的props字段进行分转元处理
     *
     * @param map
     * @param props
     */
    @SuppressWarnings("unchecked")
    public static final void fenToYuan(Map<String, Object> map, String... props) {
//		if (MapUtil.isEmpty(map) || ArrayUtil.isEmpty(props)) {
//			return;
//		}
//
//		for (String prop : props) {
//			Object value = map.get(prop);
//			if (value != null) {
//				map.put(prop, fenToYuan(LangUtil.toLong(value)));
//			}
//		}
//
//		for (Entry<String, Object> entry : map.entrySet()) {
//			if (entry.getValue() instanceof Map) {
//				fenToYuan((Map<String, Object>) entry.getValue(), props);
//			}
//			if (entry.getValue() instanceof List) {
//				List<Object> list = new ArrayList<>();
//				for (Object o : (List<?>) entry.getValue()) {
//					if (o == null) {
//						continue;
//					}
//					if (o instanceof Map) {
//						fenToYuan((Map<String, Object>) o, props);
//						list.add((Map<String, Object>) o);
//					} else if (o instanceof String || o instanceof Long || o instanceof Integer || o instanceof Boolean
//							|| o instanceof Date || o instanceof BigDecimal) {
//						list.add(o);
//					} else {
//						list.add(fenToYuan(o, props));
//					}
//				}
//				map.put(entry.getKey(), list);
//			}
//		}
    }

    /**
     * 分转元
     *
     * @param amt
     * @return
     */
    public static final BigDecimal fenToYuan(Long amt) {
        return fenToYuan(amt, 2);
    }

    /**
     * 分转元，带小数位数
     *
     * @param amt      金额（单位：分）
     * @param newScale 小数保留多少位
     * @return 四舍五入后的金额（元）
     */
    public static final BigDecimal fenToYuan(Long amt, int newScale) {
        if (amt == null) {
            return null;
        }

        return new BigDecimal(amt).divide(new BigDecimal(100), newScale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 元转分
     *
     * @param amt
     * @return
     */
    public static final Long yuanToFen(BigDecimal amt) {
        if (amt == null) {
            return null;
        }

        return amt.multiply(new BigDecimal("100")).longValue();
    }

    /**
     * Long转BigDecimal
     *
     * @param amt
     * @return
     */
    public static final BigDecimal toBigDecimal(Long amt) {
        if (amt == null) {
            return null;
        }

        return new BigDecimal(amt);
    }

    /**
     * Object转BigDecimal
     *
     * @param amt
     * @return
     */
    public static final BigDecimal objectToBigDecimal(Object amt) {
        BigDecimal ret = null;
        if (amt != null) {
            if (amt instanceof BigDecimal) {
                ret = (BigDecimal) amt;
            } else if (amt instanceof String) {
                ret = new BigDecimal((String) amt);
            } else if (amt instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) amt);
            } else if (amt instanceof Number) {
                ret = new BigDecimal(((Number) amt).doubleValue());
            } else {
                throw new ClassCastException(
                        "Not possible to coerce [" + amt + "] from class " + amt.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }
}
