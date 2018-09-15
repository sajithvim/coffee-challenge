package com.bwhitney.coffeechallenge;

import java.util.Arrays;
import com.bwhitney.coffeechallenge.billing.BillingManager;
import com.bwhitney.coffeechallenge.billing.DefaultBillingManager;
import com.bwhitney.coffeechallenge.data.UnitPriceDataProvider;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.CoffeeItem;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;
import junit.framework.TestCase;

public class TestBilling extends TestCase {

  private BillingManager billingManager;



  public void testOrderWithOneElement() throws CoffeeChallengeException {
    this.billingManager = new DefaultBillingManager(new UnitPriceDataProvider(),
        "src/test/resources/item_price_test.json");
    Order order = new Order();
    CoffeeItem coffee = new CoffeeItem();
    coffee.setItemCode("latte");
    coffee.setQuantity(1);
    order.add(coffee);
    billingManager.processOrder(order);
    assertEquals(3.5, order.getTotal(), 0.01);
    assertEquals(0.35, order.getGst(), 0.01);
  }

  public void testOrderWithSizeandAddons() throws CoffeeChallengeException {
    this.billingManager = new DefaultBillingManager(new UnitPriceDataProvider(),
        "src/test/resources/item_price_test.json");
    Order order = new Order();
    CoffeeItem cappuccino = new CoffeeItem();
    cappuccino.setItemCode("cappucinno");
    cappuccino.setQuantity(1);
    cappuccino.setItemSize("L");
    order.add(cappuccino);
    CoffeeItem flatWhite = new CoffeeItem();
    flatWhite.setItemCode("flat_white");
    flatWhite.setQuantity(1);
    flatWhite.addAddOn("soy", 1);
    order.add(flatWhite);
    billingManager.processOrder(order);
    assertEquals(8, order.getTotal(), 0.01);
    assertEquals(0.8, order.getGst(), 0.01);
  }

  public void testOrderWithSizeandAddonsWithDiscount() throws CoffeeChallengeException {
    this.billingManager = new DefaultBillingManager(new UnitPriceDataProvider(),
        "src/test/resources/item_price_test.json");
    Order order = new Order();
    CoffeeItem cappuccino = new CoffeeItem();
    cappuccino.setItemCode("cappucinno");
    cappuccino.setQuantity(1);
    cappuccino.setItemSize("L");
    order.add(cappuccino);
    CoffeeItem flatWhite = new CoffeeItem();
    flatWhite.setItemCode("flat_white");
    flatWhite.setQuantity(1);
    flatWhite.addAddOn("soy", 1);
    order.add(flatWhite);
    PromotionsModel promoModel = new PromotionsModel();
    promoModel.setPromotionType("discount");
    promoModel.setPromotionValue(0.1);
    billingManager.processOrder(order, Arrays.asList(promoModel));
    assertEquals(7.2, order.getTotal(), 0.01);
    assertEquals(0.72, order.getGst(), 0.01);
  }

  public void testOrderWithSizeandAddonsWithOneFree() throws CoffeeChallengeException {
    this.billingManager = new DefaultBillingManager(new UnitPriceDataProvider(),
        "src/test/resources/item_price_test.json");
    Order order = new Order();
    CoffeeItem cappuccino = new CoffeeItem();
    cappuccino.setItemCode("cappucinno");
    cappuccino.setQuantity(1);
    cappuccino.setItemSize("L");
    order.add(cappuccino);
    CoffeeItem flatWhite = new CoffeeItem();
    flatWhite.setItemCode("flat_white");
    flatWhite.setQuantity(1);
    order.add(flatWhite);
    PromotionsModel promoModel = new PromotionsModel();
    promoModel.setPromotionType("two-for-one");
    billingManager.processOrder(order, Arrays.asList(promoModel));
    assertEquals(4, order.getTotal(), 0.01);
    assertEquals(0.4, order.getGst(), 0.01);
  }

}
