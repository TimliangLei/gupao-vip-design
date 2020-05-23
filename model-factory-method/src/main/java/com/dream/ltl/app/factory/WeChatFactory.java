package com.dream.ltl.app.factory;

import com.dream.ltl.app.api.IPay;
import com.dream.ltl.app.api.Ifactory;
import com.dream.ltl.app.mvc.service.WeChat;

public class WeChatFactory implements Ifactory {

    public IPay create() {
        return new WeChat();
    }
}
