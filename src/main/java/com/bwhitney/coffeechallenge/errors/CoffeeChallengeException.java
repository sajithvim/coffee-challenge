package com.bwhitney.coffeechallenge.errors;

public class CoffeeChallengeException extends Exception {

  private static final long serialVersionUID = 1L;

  private ErrorCode code;

  public CoffeeChallengeException(ErrorCode code, String message) {
    super(code.toString() + " :: " + code.getMessage() + " :: " + message);
    this.code = code;
  }

  public ErrorCode getCode() {
    return code;
  }

  public void setCode(ErrorCode code) {
    this.code = code;
  }


}
