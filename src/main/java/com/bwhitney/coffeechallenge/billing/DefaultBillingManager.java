package com.bwhitney.coffeechallenge.billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.bwhitney.coffeechallenge.data.DataProvider;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.model.Item;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;
import com.bwhitney.coffeechallenge.model.UnitModel;
import com.bwhitney.coffeechallenge.promotions.PromotionsManager;
import com.bwhitney.coffeechallenge.promotions.PromotionsManagerBuilder;
import com.bwhitney.coffeechallenge.tax.TaxBuilder;
import com.bwhitney.coffeechallenge.tax.TaxManager;

public class DefaultBillingManager implements BillingManager {

  private Map<String, UnitModel> unitPrices;
  private TaxManager taxManager;

  @SuppressWarnings("unchecked")
  public DefaultBillingManager(DataProvider dataProvider, String unitDataPath)
      throws CoffeeChallengeException {
    unitPrices = (Map<String, UnitModel>) dataProvider.getUnitData(unitDataPath);
    this.taxManager = TaxBuilder.getGSTManager();
  }

  public void processOrder(Order order) {
    this.processOrder(order, null);
  }

  /**
   * Sequence of processing - Fetch the item unit prices from the driver records. - Add the size
   * related prices - Add the addon costs eg: soy milk with respect to the addon quantity. -
   * Calculate the total price for an item with these size and addon information - Multiply by the
   * quantity to get each item cost and sum to get the total for the order - Apply promotions -
   * Apply tax
   */
  public void processOrder(Order order, List<PromotionsModel> promoCodes) {
    List<Item> items = order.getItems();
    // Start calculating the order total
    double total = items.stream().mapToDouble(item -> {
      UnitModel unitDetails = unitPrices.get(item.getItemCode());
      item.setItemPrice(unitDetails.getUnitPrice());
      String size =
          (item.getItemSize() == null || item.getItemSize().isEmpty()) ? "R" : item.getItemSize();
      // Calculating intermediate value with the unit price and the size
      double price = unitDetails.getUnitPrice() + unitDetails.getSizeAdditions().get(size);
      if (item.getAddOns() != null) {
        // If there are addons, calculate the total for each of them
        List<Double> addonValues = new ArrayList<>();
        item.getAddOns().entrySet().stream().forEach(entry -> {
          double addonValue = unitDetails.getAddons().get(entry.getKey()) * entry.getValue();
          addonValues.add(addonValue);
        });
        price = price + addonValues.stream().reduce((a, b) -> a + b).get();
      }
      return item.getQuantity() * price;
    }).sum();
    order.setTotal(total);
    // Apply promotions
    if (promoCodes != null && promoCodes.size() > 0) {
      promoCodes.forEach(p -> {
        try {
          PromotionsManager promotionsManager =
              PromotionsManagerBuilder.getPromotionsManager(p.getPromotionType());
          if (promotionsManager != null) {
            promotionsManager.applyPromotion(order, p);
          }
        } catch (CoffeeChallengeException e) {
          e.printStackTrace();
        }
      });
    }
    // Apply tax
    taxManager.calculateTax(order);
  }

  public Map<String, UnitModel> getUnitPrices() {
    return unitPrices;
  }

  public void setUnitPrices(Map<String, UnitModel> unitPrices) {
    this.unitPrices = unitPrices;
  }



}
