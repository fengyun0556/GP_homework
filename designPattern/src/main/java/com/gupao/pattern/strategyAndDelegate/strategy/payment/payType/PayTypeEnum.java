package com.gupao.pattern.strategyAndDelegate.strategy.payment.payType;

public enum PayTypeEnum {
    AliPay("AliPay"),WechatPay("WechatPay"),JDPay("JDPay"),CreditCardPay("CreditCardPay");

    private String payTypeName;

    PayTypeEnum(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public String getPayTypeName() {
        return payTypeName;
    }
}
