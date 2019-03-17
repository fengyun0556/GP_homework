package com.gupao.pattern.strategyAndDelegate.strategy.payment.payType;

public class CreditCardPay implements Payment {
    @Override
    public int getBalance() {
        return 60;
    }

    @Override
    public String getPayTypeName() {
        return "信用卡支付";
    }
}
