package com.bwhitney.coffeechallenge.billing;

import java.util.List;
import java.util.Map;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;
import com.bwhitney.coffeechallenge.model.UnitModel;

public interface BillingManager {

  public void processOrder(Order order);

  public void processOrder(Order order, List<PromotionsModel> promoCodes);

  public Map<String, UnitModel> getUnitPrices();

}
