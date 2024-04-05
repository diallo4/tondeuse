package com.mowitnow.demo.robot;

import com.mowitnow.demo.robot.exception.InstructionException;
import com.mowitnow.demo.robot.instruction.Instruction;
import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;

public interface Robot {

  DirectedPosition dryRun(Instruction instruction) throws InstructionException;
  void run(Instruction action) throws InstructionException;

  Position getPosition();
  Direction getDirection();

}
