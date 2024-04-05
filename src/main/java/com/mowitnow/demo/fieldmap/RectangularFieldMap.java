package com.mowitnow.demo.fieldmap;

import com.mowitnow.demo.robot.mower.direction.Position;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class RectangularFieldMap implements FieldMap {

  private int maxX;
  private int maxY;

  @Override
  public boolean accept(Position position) {
    return position.getX() >= 0 && position.getX() <= this.maxX
        && position.getY() >= 0 && position.getY() <= this.maxY;
  }

  @Override
  public String toString() {
    return String.format("RectangularMap [x:%d y:%d]", this.maxX, this.maxY);
  }

}
