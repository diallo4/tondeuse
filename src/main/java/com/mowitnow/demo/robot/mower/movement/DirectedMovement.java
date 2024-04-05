package com.mowitnow.demo.robot.mower.movement;

import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;

public abstract class DirectedMovement implements Movement {

  @Override
  public DirectedPosition executeFrom(DirectedPosition directedPosition) {
    if (directedPosition.getDirection().equals(Direction.N)) {
      return executeFromN(directedPosition);
    }
    else if (directedPosition.getDirection().equals(Direction.E)) {
      return executeFromE(directedPosition);
    }
    else if (directedPosition.getDirection().equals(Direction.S)) {
      return executeFromS(directedPosition);
    }
    else if (directedPosition.getDirection().equals(Direction.W)) {
      return executeFromW(directedPosition);
    }
    else {
      return directedPosition;
    }
  }

  abstract protected DirectedPosition executeFromN(DirectedPosition orientedPosition);
  abstract protected DirectedPosition executeFromE(DirectedPosition orientedPosition);
  abstract protected DirectedPosition executeFromW(DirectedPosition orientedPosition);
  abstract protected DirectedPosition executeFromS(DirectedPosition orientedPosition);
}
