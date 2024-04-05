package com.mowitnow.demo.robot.mower;

import com.mowitnow.demo.robot.Robot;
import com.mowitnow.demo.robot.exception.InstructionException;
import com.mowitnow.demo.robot.instruction.Instruction;
import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;
import com.mowitnow.demo.robot.mower.movement.Forward;
import com.mowitnow.demo.robot.mower.movement.Left;
import com.mowitnow.demo.robot.mower.movement.Movement;
import com.mowitnow.demo.robot.mower.movement.Right;
import java.util.HashMap;
import java.util.Map;

public class Mower implements Robot {
  private Position position;
  private Direction direction;

  private Map<Instruction, Movement> movements;



  public Mower(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;

    this.movements = new HashMap<>();
    this.movements.put(new Instruction('A'), new Forward());
    this.movements.put(new Instruction('D'), new Right());
    this.movements.put(new Instruction('G'), new Left());
  }

  @Override
  public Direction getDirection() {
    return direction;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public DirectedPosition dryRun(Instruction instruction) throws InstructionException {
    DirectedPosition actualOrientedPosition = new DirectedPosition(this.getDirection(), this.position);
    return getMovement(instruction).executeFrom(actualOrientedPosition);
  }

  @Override
  public void run(Instruction instruction) throws InstructionException {
    DirectedPosition actualDirectedPosition = new DirectedPosition(this.getDirection(), this.position);
    DirectedPosition newDirectedPosition = getMovement(instruction).executeFrom(actualDirectedPosition);
    this.position = newDirectedPosition.getPosition();
    this.direction = newDirectedPosition.getDirection();
  }

  private Movement getMovement(Instruction instruction) throws InstructionException {
    for (Map.Entry<Instruction, Movement> keyValue : this.movements.entrySet()) {
      if (keyValue.getKey().equals(instruction)) {
        return keyValue.getValue();
      }
    }
    throw new InstructionException(String.format("L'instruction %s n'existe pas.", instruction));
  }

  @Override
  public String toString() {
    return String.format("Tondeuse : %s - %s", this.position, this.direction);
  }

}
