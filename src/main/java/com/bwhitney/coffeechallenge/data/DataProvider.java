package com.bwhitney.coffeechallenge.data;

import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;

public interface DataProvider {

  public Object getUnitData(String source) throws CoffeeChallengeException;

}
