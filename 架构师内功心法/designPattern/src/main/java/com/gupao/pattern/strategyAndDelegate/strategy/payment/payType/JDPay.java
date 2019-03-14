package com.gupao.pattern.strategyAndDelegate.strategy.payment.payType;

public class JDPay implements Payment {
    @Override
    public int getBalance() {
        return 90;
    }

    @Override
    public String getPayTypeName() {
        return "京东支付";
    }
}
