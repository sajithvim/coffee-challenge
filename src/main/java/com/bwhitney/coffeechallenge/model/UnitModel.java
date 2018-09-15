package com.bwhitney.coffeechallenge.model;

import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class UnitModel {

  @SerializedName("product_code")
  private String productCode;

  @SerializedName("unit_price")
  private double unitPrice;

  @SerializedName("tax_policy")
  private String taxPolicy;

  @SerializedName("size_additions")
  private Map<String, Double> sizeAdditions;

  private Map<String, Double> addons;

  public Map<String, Double> getAddons() {
    return addons;
  }

  public void setAddons(Map<String, Double> addons) {
    this.addons = addons;
  }

  public Map<String, Double> getSizeAdditions() {
    return sizeAdditions;
  }

  public void setSizeAdditions(Map<String, Double> sizeAdditions) {
    this.sizeAdditions = sizeAdditions;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getTaxPolicy() {
    return taxPolicy;
  }

  public void setTaxPolicy(String taxPolicy) {
    this.taxPolicy = taxPolicy;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }


}
