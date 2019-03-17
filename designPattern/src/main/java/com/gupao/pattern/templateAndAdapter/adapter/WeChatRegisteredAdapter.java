package com.gupao.pattern.templateAndAdapter.adapter;

import java.util.UUID;

/**
 * 使用微信账号注册
 */
public class WeChatRegisteredAdapter {

    public void registered(String weChatId){
        String password = UUID.randomUUID().toString();

        OldRegisteredService oldRegisteredService = new OldRegisteredService();
        oldRegisteredService.registered(weChatId, password);
    }
}
