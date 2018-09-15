package com.bwhitney.coffeechallenge.tax;

import com.bwhitney.coffeechallenge.util.Constants;

public class TaxBuilder {

  public static TaxManager getGSTManager() {
    return new GSTManager(Constants.DEFAULT_GST_RATE);
  }

}
