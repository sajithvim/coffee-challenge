package com.bwhitney.coffeechallenge.tax;

import com.bwhitney.coffeechallenge.model.Order;

public interface TaxManager {

  public void calculateTax(Order order);

}
