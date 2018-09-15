package com.bwhitney.coffeechallenge.promotions;

import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.errors.ErrorCode;

public class PromotionsManagerBuilder {


  private static PromotionsManager discountManager = new TotalDiscountManager();

  private static PromotionsManager twoForOneManager = new TwoForOnePromotionManager();


  public static PromotionsManager getPromotionsManager(String type)
      throws CoffeeChallengeException {
    if ("discount".equalsIgnoreCase(type)) {
      return discountManager;
    } else if ("two-for-one".equalsIgnoreCase(type)) {
      return twoForOneManager;
    } else {
      throw new CoffeeChallengeException(ErrorCode.E101, "Invalid promotion type");
    }

  }

}
