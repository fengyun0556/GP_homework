package com.study.gupao.netty.protocal;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvokerProtocol implements Serializable {
    private String className;//类名
    private String methodName;//函数名称
    private Class<?>[] params;//参数类型
    private Object[] values;//参数列表
}
