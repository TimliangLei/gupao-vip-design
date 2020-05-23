package com.dream.ltl.app.promotion;

import com.dream.ltl.app.promotion.factories.PromotionStrategyFactory;

public class App {
    public static void main(String[] args) {
        PromotionStrategyFactory.getPromotionStrategy();

        PromotionStrategyFactory.getPromotionStrategy("COUPON");
    }
}
