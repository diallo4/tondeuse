package com.mowitnow.demo.robot.mower.direction;

import com.mowitnow.demo.robot.exception.InvalidDirectionException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Direction {

  private char direction;

  public Direction(char direction) throws InvalidDirectionException {
    if (!"NESO".contains(Character.toString(direction))) {
      throw new InvalidDirectionException(String.format("La direction %c n'existe pas", direction));
    }
    this.direction = direction;
  }


  @Override
  public String toString() {
    return String.format("Orientation [%c]", this.direction);
  }

  public static final Direction N = instantiate('N');
  public static final Direction E = instantiate('E');
  public static final Direction S = instantiate('S');
  public static final Direction W = instantiate('O');

  private static Direction instantiate(char direction) {
    try {
      return new Direction(direction);
    } catch (InvalidDirectionException e) {
      throw new RuntimeException("Orientation invalide lors de la construction");
    }
  }
}
