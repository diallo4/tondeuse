package com.mowitnow.demo.robot.mower.movement;

import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;

public class Left extends DirectedMovement {

  @Override
  protected DirectedPosition executeFromN(DirectedPosition directedPosition) {
    return new DirectedPosition(Direction.W, directedPosition.getPosition());
  }

  @Override
  protected DirectedPosition executeFromE(DirectedPosition directedPosition) {
    return new DirectedPosition(Direction.N, directedPosition.getPosition());
  }

  @Override
  protected DirectedPosition executeFromS(DirectedPosition directedPosition) {
    return new DirectedPosition(Direction.E, directedPosition.getPosition());
  }

  @Override
  protected DirectedPosition executeFromW(DirectedPosition directedPosition) {
    return new DirectedPosition(Direction.S, directedPosition.getPosition());
  }

}
