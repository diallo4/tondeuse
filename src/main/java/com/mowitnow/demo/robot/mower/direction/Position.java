package com.mowitnow.demo.robot.mower.direction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Position {

  private int x;
  private int y;

  public Position add(int x, int y) {
    return new Position(this.x + x, this.y + y);
  }

  @Override
  public String toString() {
    return String.format("Position [x:%s,y:%s]", this.x, this.y);
  }

}
