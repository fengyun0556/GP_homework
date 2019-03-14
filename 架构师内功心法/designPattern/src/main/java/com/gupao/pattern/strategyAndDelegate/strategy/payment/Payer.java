package com.gupao.pattern.strategyAndDelegate.strategy.payment;

import com.gupao.pattern.strategyAndDelegate.strategy.payment.payType.Payment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Payer {

    private Map<String, Payment> paymentMap = new ConcurrentHashMap<>(4);

    public Payment getPayment(String payType) {
        try {
            Payment payment;
            if (paymentMap.containsKey(payType)){
                payment = paymentMap.get(payType);
            }else {
                String className = "com.gupao.pattern.strategyAndDelegate.strategy.payment.payType." + payType;
                Class clazz = Class.forName(className);
                payment = (Payment) clazz.newInstance();
            }
            return payment;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


}
