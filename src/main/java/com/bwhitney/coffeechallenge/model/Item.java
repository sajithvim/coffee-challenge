package com.bwhitney.coffeechallenge.model;

import java.util.HashMap;
import java.util.Map;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;

public class Item {

  private String itemCode;

  private double itemPrice;

  private double itemGst;

  private double quantity;

  private String itemSize;

  private Map<String, Integer> addOns;

  public void addAddOn(String code, int amount) {
    if (this.addOns == null) {
      this.addOns = new HashMap<>();
    }
    if (amount == 0) {
      ++amount;
    }
    this.addOns.put(code, amount);
  }


  public String getItemSize() {
    return itemSize;
  }

  public void setItemSize(String itemSize) {
    this.itemSize = itemSize;
  }

  public Map<String, Integer> getAddOns() {
    return addOns;
  }

  public void setAddOns(Map<String, Integer> addOns) {
    this.addOns = addOns;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) throws CoffeeChallengeException {
    this.quantity = quantity;
  }

  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(double itemPrice) {
    this.itemPrice = itemPrice;
  }

  public double getItemGst() {
    return itemGst;
  }

  public void setItemGst(double itemGst) {
    this.itemGst = itemGst;
  }


}
