package com.dream.ltl.pattern.adapter.power.objectadapter;



public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int input = this.ac220.outputAC220V();
        int output = input/44;
        System.out.println("使用Adpater输入AC"+input+"V,输出DC"+output+"V");
        return 0;
    }
}
