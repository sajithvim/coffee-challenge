package com.bwhitney.coffeechallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

  private List<Item> items;

  private double total;

  private double gst;

  public void add(Item item) {
    if (this.items == null) {
      items = new ArrayList<Item>();
    }
    this.items.add(item);
  }


  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public double getGst() {
    return gst;
  }

  public void setGst(double gst) {
    this.gst = gst;
  }



}
