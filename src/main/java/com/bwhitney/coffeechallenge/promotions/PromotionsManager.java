package com.bwhitney.coffeechallenge.promotions;

import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;

public interface PromotionsManager {

  public void applyPromotion(Order order, PromotionsModel promotionsModel);

}
