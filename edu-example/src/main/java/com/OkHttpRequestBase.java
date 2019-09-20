package com;

import java.io.Serializable;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public class OkHttpRequestBase implements Serializable {
    /**
     * 网关商户号，固定值
     */
    private String merchantCode;
    /**
     * 商户的用户id，唯一标识一个用户
     */
    private String merchantUserId;
    /**
     * 京东金融账户ID（空值不验签）
     */
    private String jrOpenId;
    /**
     * RSA数字签名
     */
    private String sign;
    /**
     * AES密钥
     */
    private String key;
    /**
     * 字符集，当前版本仅支持UTF-8
     */
    private String charset = "UTF-8";
    /**
     * AES加密后的数据报文
     */
    private String body;
    /**
     * 接口类型枚举，由白条侧研发提供
     */
    private String type;
    /**
     * 网关版本号，由白条侧提供，默认1.0
     */
    private String version = "1.0";
    /**
     * 京东侧密钥token（老商户不填写）
     */
    private String token;

    public OkHttpRequestBase build() {
        setMerchantCode("2380000001_4748").setMerchantUserId("SFY0349400503").setJrOpenId("1809384736475806504");
        return this;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    private OkHttpRequestBase setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
        return this;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    private OkHttpRequestBase setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
        return this;
    }

    public String getJrOpenId() {
        return jrOpenId;
    }

    private OkHttpRequestBase setJrOpenId(String jrOpenId) {
        this.jrOpenId = jrOpenId;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OkHttpRequestBase setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getKey() {
        return key;
    }

    public OkHttpRequestBase setKey(String key) {
        this.key = key;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public OkHttpRequestBase setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getBody() {
        return body;
    }

    public OkHttpRequestBase setBody(String body) {
        this.body = body;
        return this;
    }

    public String getType() {
        return type;
    }

    public OkHttpRequestBase setType(String type) {
        this.type = type;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public OkHttpRequestBase setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getToken() {
        return token;
    }

    public OkHttpRequestBase setToken(String token) {
        this.token = token;
        return this;
    }
}
