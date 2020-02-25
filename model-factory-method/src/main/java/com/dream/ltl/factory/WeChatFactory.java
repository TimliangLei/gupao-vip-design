package com.dream.ltl.factory;

import com.dream.ltl.api.IPay;
import com.dream.ltl.api.Ifactory;
import com.dream.ltl.service.WeChat;

public class WeChatFactory implements Ifactory {

    public IPay create() {
        return new WeChat();
    }
}
