package com.mowitnow.demo.fieldmap;

import com.mowitnow.demo.robot.mower.direction.Position;

public interface FieldMap {

  boolean accept(Position position);
}
