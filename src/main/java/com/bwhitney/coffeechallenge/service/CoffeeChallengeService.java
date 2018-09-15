package com.bwhitney.coffeechallenge.service;

import java.util.List;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;

public interface CoffeeChallengeService {

  public void processOrder(Order order, List<PromotionsModel> promotions);

}
