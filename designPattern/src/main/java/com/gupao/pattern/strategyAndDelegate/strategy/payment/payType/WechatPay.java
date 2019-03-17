package com.gupao.pattern.strategyAndDelegate.strategy.payment.payType;

public class WechatPay implements Payment {
    @Override
    public int getBalance() {
        return 200;
    }

    @Override
    public String getPayTypeName() {
        return "微信支付";
    }
}
