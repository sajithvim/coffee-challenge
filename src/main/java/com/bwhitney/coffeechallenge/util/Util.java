package com.bwhitney.coffeechallenge.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import com.bwhitney.coffeechallenge.errors.CoffeeChallengeException;
import com.bwhitney.coffeechallenge.errors.ErrorCode;

public class Util {

  public static String readJsonFile(String path) throws CoffeeChallengeException {
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      return lines.reduce((a, b) -> a + "/n" + b).get().replaceAll("/n", "");
    } catch (IOException e) {
      e.printStackTrace();
      throw new CoffeeChallengeException(ErrorCode.E100, e.getMessage());
    }
  }

}
