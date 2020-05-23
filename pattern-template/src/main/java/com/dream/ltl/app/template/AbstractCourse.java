package com.dream.ltl.app.template;

public abstract class AbstractCourse {
    protected final void createCourse(){
        //1.发布预习资料
        postPreResource();
        //2.制作课件
        createPPT();
        //3.直播授课
        liveVideo();
        //4.课后资料
        postResource();
        //5.作业
        postHomeWork();
        
        if(needCheckHomeWork())
            checkHomeWork();
    }

    protected abstract void checkHomeWork();

    //钩子方法
    protected boolean needCheckHomeWork(){
        return false;
    }
    
    protected void postHomeWork(){
        System.out.println("作业");
    }

    protected  void postResource(){
        System.out.println("课后资料");
    }

    protected  void liveVideo(){
        System.out.println("直播授课");
    }

    protected  void createPPT(){
        System.out.println("制作课件");
    }

    protected  void postPreResource(){
        System.out.println("发布预习资料");
    }


}
