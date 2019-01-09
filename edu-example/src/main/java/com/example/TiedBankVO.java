package com.example;

/**
 * <pre>
 * 搭售配置银行对象
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/18
 */
public class TiedBankVO {

    private String bankCode;
    private String bankName;
    private boolean usabled;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public boolean isUsabled() {
        return usabled;
    }

    public void setUsabled(boolean usabled) {
        this.usabled = usabled;
    }
}
