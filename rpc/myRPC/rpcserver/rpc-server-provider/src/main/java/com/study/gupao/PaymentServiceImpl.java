package com.study.gupao;

@RpcService(IPaymentService.class)
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public void doPay() {
        System.out.println("执行doPay方法");
    }
}
