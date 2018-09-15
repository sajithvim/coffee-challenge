package com.bwhitney.coffeechallenge.model;

import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.errors.ErrorCode;

public class PromotionsModel {

  private String promotionType;

  private String promotionCode;

  private double promotionValue = -1;


  public double getPromotionValue() {
    return promotionValue;
  }

  public void setPromotionValue(double promotionValue) throws CoffeeChallengeException {
    if (promotionValue > 1) {
      throw new CoffeeChallengeException(ErrorCode.E102,
          "Discount should be a valid percentage less than 100%");
    }
    this.promotionValue = promotionValue;
  }

  public String getPromotionType() {
    return promotionType;
  }

  public void setPromotionType(String promotionType) {
    this.promotionType = promotionType;
  }

  public String getPromotionCode() {
    return promotionCode;
  }

  public void setPromotionCode(String promotionCode) {
    this.promotionCode = promotionCode;
  }


}
