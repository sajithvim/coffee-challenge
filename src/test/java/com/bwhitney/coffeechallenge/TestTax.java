package com.bwhitney.coffeechallenge;

import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.tax.GSTManager;
import com.bwhitney.coffeechallenge.tax.TaxManager;
import junit.framework.TestCase;

public class TestTax extends TestCase {

  private TaxManager taxManager;

  public void testCalculateTaxForWholeNumber() {
    taxManager = new GSTManager(0.12);
    Order order = new Order();
    order.setTotal(10252);
    taxManager.calculateTax(order);
    assertEquals(1230.24, order.getGst(), 0.5);
  }

}
