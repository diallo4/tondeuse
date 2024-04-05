package com.mowitnow.demo.robot.mower.movement;

import com.mowitnow.demo.robot.mower.direction.DirectedPosition;

public class Forward extends DirectedMovement{

  @Override
  protected DirectedPosition executeFromN(DirectedPosition directedPosition) {
    return new DirectedPosition(directedPosition.getDirection(), directedPosition.getPosition().add(0 ,1));
  }

  @Override
  protected DirectedPosition executeFromE(DirectedPosition directedPosition) {
    return new DirectedPosition(directedPosition.getDirection(), directedPosition.getPosition().add(1 ,0));
  }

  @Override
  protected DirectedPosition executeFromS(DirectedPosition directedPosition) {
    return new DirectedPosition(directedPosition.getDirection(), directedPosition.getPosition().add(0 ,-1));
  }

  @Override
  protected DirectedPosition executeFromW(DirectedPosition directedPosition) {
    return new DirectedPosition(directedPosition.getDirection(), directedPosition.getPosition().add(-1 ,0));
  }

}
