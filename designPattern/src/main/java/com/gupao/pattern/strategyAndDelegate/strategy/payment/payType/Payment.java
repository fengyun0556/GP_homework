package com.gupao.pattern.strategyAndDelegate.strategy.payment.payType;

public interface Payment {
    /** 获取余额 */
    int getBalance();
    /** 获取支付类型的方式 */
    String getPayTypeName();

    /** 扣款 */
    default boolean deduction(int cost){
        int balanceAfterDeduction = this.getBalance() - cost;
        System.out.println("扣款后余额：" + balanceAfterDeduction);
        return balanceAfterDeduction >= 0;
    }

}
