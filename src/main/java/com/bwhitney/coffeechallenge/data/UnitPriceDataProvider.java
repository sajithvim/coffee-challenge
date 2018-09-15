package com.bwhitney.coffeechallenge.data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.UnitDataHolder;
import com.bwhitney.coffeechallenge.model.UnitModel;
import com.bwhitney.coffeechallenge.util.Util;
import com.google.gson.Gson;

public class UnitPriceDataProvider implements DataProvider {

  private Gson gson = new Gson();

  @Override
  public Object getUnitData(String source) throws CoffeeChallengeException {
    String content = Util.readJsonFile(source);
    List<UnitModel> unitPrices = gson.fromJson(content, UnitDataHolder.class).getPrices();
    Map<String, UnitModel> unitModelMap = unitPrices.stream()
        .collect(Collectors.toMap(model -> model.getProductCode(), model -> model));
    return unitModelMap;
  }

}
