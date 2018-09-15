package com.bwhitney.coffeechallenge.errors;

public enum ErrorCode {

  E100("Error_reading_unit_values"), E101("Validation error"), E102("Processing error");

  private String message;

  ErrorCode(String msg) {
    this.setMessage(msg);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
