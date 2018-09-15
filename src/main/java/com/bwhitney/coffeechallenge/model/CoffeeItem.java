package com.bwhitney.coffeechallenge.model;

import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.errors.ErrorCode;

public class CoffeeItem extends Item {

  public CoffeeItem(String code) {
    this.setItemCode(code);
  }

  public CoffeeItem() {}

  @Override
  public void setQuantity(double quantity) throws CoffeeChallengeException {
    if (quantity < 0) {
      throw new CoffeeChallengeException(ErrorCode.E101,
          "Coffee quantity should be greater than one");
    }
    if ((quantity != Math.floor(quantity)) || Double.isInfinite(quantity)) {
      throw new CoffeeChallengeException(ErrorCode.E101,
          "Coffee quantity should be a finite whole number");
    }
    super.setQuantity(quantity);
  }

}
