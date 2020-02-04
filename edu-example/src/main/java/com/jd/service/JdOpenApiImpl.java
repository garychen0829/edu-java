package com.jd.service;

import com.OkHttpRequestBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jd.JdKeys;
import com.jd.domain.AreaRequest;
import com.jd.domain.AreasInfo;
import com.jd.intef1.IJdOpenApi;
import com.jd.jdsdk.utils.AES;
import com.jd.jdsdk.utils.RSA;
import com.jd.jdsdk.utils.RandomUtil;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import util.OkHttpUtils;
import util.RealCallback;

import java.io.IOException;
import java.util.List;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public class JdOpenApiImpl implements IJdOpenApi {

    private String jd_url = "http://test.btgateway.jd.com/service/gatewayproxy";

    /**
     * 查询省市区县
     *
     * @return
     */
    @Override
    public List<AreasInfo> getAreas() throws Exception {
        //List<AreasInfo> areasInfos = new ArrayList<>();
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();

        OkHttpRequestBase request = new OkHttpRequestBase().build();

        request.setType("2012");

        AreaRequest areaRequest = new AreaRequest();
        areaRequest.setParentId("2");
        areaRequest.setType("100");

        String bodyStr = JSONObject.toJSONString(areaRequest);
        // 1、使用RSA算法生成签名
        String signStr = (new StringBuffer()).append(request.getMerchantCode()).append(request.getMerchantUserId()).append(request.getJrOpenId()).append(request.getCharset()).
                append(request.getType()).append(request.getVersion()).append(bodyStr).toString();
        request.setSign(RSA.sign(signStr, JdKeys.tc_private_key));

        // 2、随机生成16位AES密钥
        String aesKey = RandomUtil.getRandom(16);
        System.out.println("aesKey:" + aesKey);

        // 3、使用AES算法加密入参
        String bodyStrEncrypted = AES.encryptToBase64(bodyStr, aesKey);
        request.setBody(bodyStrEncrypted); // 加密后报文

        // 4、使用RSA算法加密aesKey
        String aesKeyEncrypted = RSA.encrypt(aesKey, JdKeys.jd_public_key);
        request.setKey(aesKeyEncrypted); // 加密后的aesKey
        System.out.println("网关入参组装完毕：" + JSON.toJSONString(request));


        System.out.println("signVal=" + signStr);
        System.out.println("signVal rsa=" + request.getSign());

        System.out.println("body=" + JSONObject.toJSONString(areaRequest));
        System.out.println("body enc=" + bodyStr);

        System.out.println("aesKey=" + aesKey);
        System.out.println("aesKey encrypt=" + aesKeyEncrypted);

        System.out.println("request=" + JSONObject.toJSONString(request));

        okHttpUtils.post(jd_url, RequestBody.create(MediaType.parse("application/json"), JSONObject.toJSONString(request)), new RealCallback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    try {
                        System.out.println(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("--- error ---");
            }
        });

        return null;
    }


    public static void main(String[] args) {

        IJdOpenApi api = new JdOpenApiImpl();
        try {
            api.getAreas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
