package com.mowitnow.demo.robot.mower.direction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class DirectedPosition {

  private Direction direction;
  private Position position;

  @Override
  public String toString() {
    return String.format("%s - %s", this.position, this.direction);
  }

}
