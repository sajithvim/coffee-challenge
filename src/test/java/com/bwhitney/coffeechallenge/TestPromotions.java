package com.bwhitney.coffeechallenge;

import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.CoffeeItem;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;
import com.bwhitney.coffeechallenge.promotions.PromotionsManager;
import com.bwhitney.coffeechallenge.promotions.TotalDiscountManager;
import com.bwhitney.coffeechallenge.promotions.TwoForOnePromotionManager;
import junit.framework.TestCase;

public class TestPromotions extends TestCase {

  private PromotionsManager promotionsManager;

  public void testDiscountPromotionDefault() {
    promotionsManager = new TotalDiscountManager();
    Order order = new Order();
    order.setTotal(10.50);
    promotionsManager.applyPromotion(order, new PromotionsModel());
    assertEquals(9.45, order.getTotal(), 0.01);
  }

  public void testDefinedPromotionPercentage() throws CoffeeChallengeException {
    promotionsManager = new TotalDiscountManager();
    Order order = new Order();
    order.setTotal(10.50);
    PromotionsModel promoModel = new PromotionsModel();
    promoModel.setPromotionValue(0.25);
    promotionsManager.applyPromotion(order, promoModel);
    assertEquals(7.87, order.getTotal(), 0.01);
  }

  public void testTwoForOnePromotionWithSingleQuantity() throws CoffeeChallengeException {
    promotionsManager = new TwoForOnePromotionManager();
    Order order = new Order();

    CoffeeItem coffee1 = new CoffeeItem();
    coffee1.setItemPrice(10);
    coffee1.setQuantity(1);
    order.add(coffee1);

    CoffeeItem coffee2 = new CoffeeItem();
    coffee2.setItemPrice(12);
    coffee2.setQuantity(1);
    order.add(coffee2);

    order.setTotal(22);

    promotionsManager.applyPromotion(order, new PromotionsModel());
    assertEquals(12, order.getTotal(), 0.01);
  }

  public void testTwoForOneWithMultipleQuantities() throws CoffeeChallengeException {
    promotionsManager = new TwoForOnePromotionManager();
    Order order = new Order();

    CoffeeItem coffee1 = new CoffeeItem();
    coffee1.setItemPrice(6);
    coffee1.setQuantity(3);
    order.add(coffee1);

    CoffeeItem coffee2 = new CoffeeItem();
    coffee2.setItemPrice(10);
    coffee2.setQuantity(2);
    order.add(coffee2);

    order.setTotal(38);

    promotionsManager.applyPromotion(order, new PromotionsModel());
    assertEquals(32, order.getTotal(), 0.01);
  }

}
