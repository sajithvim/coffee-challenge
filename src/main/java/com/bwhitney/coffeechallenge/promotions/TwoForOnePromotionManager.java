package com.bwhitney.coffeechallenge.promotions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.bwhitney.coffeechallenge.model.CoffeeItem;
import com.bwhitney.coffeechallenge.model.Item;
import com.bwhitney.coffeechallenge.model.Order;
import com.bwhitney.coffeechallenge.model.PromotionsModel;

public class TwoForOnePromotionManager implements PromotionsManager {

  @Override
  public void applyPromotion(Order order, PromotionsModel promotionsModel) {
    List<Item> items = order.getItems();
    List<Item> effectiveItems = new ArrayList<>();
    items.forEach(item -> {
      if (item.getQuantity() == 1) {
        effectiveItems.add(item);
      } else {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < item.getQuantity(); i++) {
          Item newItem = new CoffeeItem();
          newItem.setItemPrice(item.getItemPrice());
          list.add(newItem);
        }
        effectiveItems.addAll(list);
      }
    });
    Item minItem = effectiveItems.stream().min(Comparator.comparing(Item::getItemPrice)).get();
    double newTotal = order.getTotal() - minItem.getItemPrice();
    order.setTotal(newTotal);
  }

}
