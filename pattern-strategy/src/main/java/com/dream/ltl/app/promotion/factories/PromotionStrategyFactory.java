package com.dream.ltl.app.promotion.factories;

import com.dream.ltl.app.promotion.*;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String, IPromotionStrategy> PROMOTIONS = new HashMap<>();
    static {
        PROMOTIONS.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK,new CashBackStrategy());
        PROMOTIONS.put(PromotionKey.GROUPBY,new GroupByStrategy());
        PROMOTIONS.put(PromotionKey.EMPTY,new EmptyStrategy());
    }
    private PromotionStrategyFactory() {
    }
    public static IPromotionStrategy getPromotionStrategy(String param){
        return PROMOTIONS.get(param);
    }
    public static IPromotionStrategy getPromotionStrategy(){
        return PROMOTIONS.get(PromotionKey.EMPTY);
    }
    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBY = "GROUPBY";
        String EMPTY = "EMPTY";
    }
}
