package com.gupao.pattern.strategyAndDelegate.strategy.payment;

import com.gupao.pattern.strategyAndDelegate.strategy.payment.payType.PayTypeEnum;
import com.gupao.pattern.strategyAndDelegate.strategy.payment.payType.Payment;

public class PaymentTest {
    public static void main(String[] args) {
        Payer payer = new Payer();
        Payment payment = payer.getPayment(PayTypeEnum.AliPay.getPayTypeName());
        boolean result = payment.deduction(200);

        if (result){
            System.out.println("扣款成功");
        } else {
            System.out.println("扣款失败");
        }
    }
}
