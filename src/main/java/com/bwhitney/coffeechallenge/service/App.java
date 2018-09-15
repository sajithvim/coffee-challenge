package com.bwhitney.coffeechallenge.service;

import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.CoffeeItem;
import com.bwhitney.coffeechallenge.model.Item;
import com.bwhitney.coffeechallenge.model.Order;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    CoffeeChallengeService service = new CoffeeChallengeServiceImpl();
    System.out.println("Generating the bill for the following:");
    System.out.println(" - espresso");
    System.out.println(" - large cappuccino");
    System.out.println(" - soy flat white");
    System.out.println(" - cappuccino");

    try {
      Order order = new Order();

      Item espresso = new CoffeeItem("espresso");
      espresso.setQuantity(1);

      Item lCap = new CoffeeItem("cappuccino");
      lCap.setItemSize("L");
      lCap.setQuantity(1);

      Item sFlatWhite = new CoffeeItem("flat_white");
      sFlatWhite.setQuantity(1);
      sFlatWhite.addAddOn("soy", 1);

      Item cap = new CoffeeItem("cappuccino");
      cap.setQuantity(1);

      order.add(espresso);
      order.add(lCap);
      order.add(sFlatWhite);
      order.add(cap);

      service.processOrder(order, null);
      System.out.println("***********************************");
      System.out.println("Total : " + order.getTotal());
      System.out.println("GST : " + (Math.round(order.getGst() * 100.0)) / 100.0);

    } catch (CoffeeChallengeException e) {
      e.printStackTrace();
    }
  }
}
