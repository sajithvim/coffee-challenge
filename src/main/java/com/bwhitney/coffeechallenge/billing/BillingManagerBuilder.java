package com.bwhitney.coffeechallenge.billing;

import com.bwhitney.coffeechallenge.data.UnitPriceDataProvider;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;

public class BillingManagerBuilder {

  public static BillingManager getDefaultBillingManager(String unitDataPath)
      throws CoffeeChallengeException {
    BillingManager billingManager =
        new DefaultBillingManager(new UnitPriceDataProvider(), unitDataPath);
    return billingManager;
  }

}
