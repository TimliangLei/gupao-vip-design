package com.gupao.loadbalance;

import java.util.List;
import java.util.Random;

public class RandomLoadBalance implements LoadBalance {
    @Override
    public String select(List<String> repos) {
        int len=repos.size();
        Random random=new Random();
        return repos.get(random.nextInt(len));
    }
}
