package com.bwhitney.coffeechallenge.service;

import java.util.List;
import com.bwhitney.coffeechallenge.billing.BillingManager;
import com.bwhitney.coffeechallenge.billing.BillingManagerBuilder;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;

public class CoffeeChallengeServiceImpl implements CoffeeChallengeService {

  @Override
  public void processOrder(Order order, List<PromotionsModel> promotions) {
    try {
      BillingManager billingManager =
          BillingManagerBuilder.getDefaultBillingManager("src/main/resources/item_price.json");
      billingManager.processOrder(order);
    } catch (CoffeeChallengeException e) {
      e.printStackTrace();
    }

  }
}
