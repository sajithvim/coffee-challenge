package com.bwhitney.coffeechallenge.tax;

import com.bwhitney.coffeechallenge.model.Order;

public class GSTManager implements TaxManager {

  private double gstRate;

  public GSTManager(double gstRate) {
    this.gstRate = gstRate;
  }

  @Override
  public void calculateTax(Order order) {
    double gstAmount = order.getTotal() * gstRate;
    order.setGst(gstAmount);
  }

}
