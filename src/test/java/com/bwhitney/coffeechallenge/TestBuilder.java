package com.bwhitney.coffeechallenge;


import java.util.Map;
import org.junit.Test;
import com.bwhitney.coffeechallenge.billing.BillingManager;
import com.bwhitney.coffeechallenge.billing.BillingManagerBuilder;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.UnitModel;
import junit.framework.TestCase;

public class TestBuilder extends TestCase {

  @Test
  public void testBillingBuilderWithDefaults() throws CoffeeChallengeException {
    String unitDataPath = "src/test/resources/item_price_test.json";
    BillingManager manager = BillingManagerBuilder.getDefaultBillingManager(unitDataPath);
    Map<String, UnitModel> unitPrices = manager.getUnitPrices();
    assertEquals("latte", unitPrices.get("latte").getProductCode());
    assertEquals(3.5, unitPrices.get("latte").getUnitPrice());
    assertEquals("STANDARD", unitPrices.get("latte").getTaxPolicy());
  }

}
