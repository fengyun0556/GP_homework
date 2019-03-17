package com.gupao.pattern.strategyAndDelegate.strategy.payment.payType;

public class AliPay implements Payment {
    @Override
    public int getBalance() {
        return 10000;
    }

    @Override
    public String getPayTypeName() {
        return "支付宝";
    }
}
