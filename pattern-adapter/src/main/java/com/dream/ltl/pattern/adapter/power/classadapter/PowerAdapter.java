package com.dream.ltl.pattern.adapter.power.classadapter;

public class PowerAdapter extends AC220 implements DC5 {
    @Override
    public int output5V() {
        int input = super.outputAC220V();
        int output = input/44;
        System.out.println("使用Adpater输入AC"+input+"V,输出DC"+output+"V");
        return 0;
    }
}
