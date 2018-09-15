package com.bwhitney.coffeechallenge.promotions;

import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;
import com.bwhitney.coffeechallenge.util.Constants;

public class TotalDiscountManager implements PromotionsManager {

  @Override
  public void applyPromotion(Order order, PromotionsModel promotionsModel) {
    double discountPercentage =
        promotionsModel.getPromotionValue() != -1 ? promotionsModel.getPromotionValue()
            : Constants.DEFAULT_DISCOUNT_PROMOTIONS_PERCENTAGE;
    double total = order.getTotal() * (1 - discountPercentage);
    order.setTotal(total);
  }

}
