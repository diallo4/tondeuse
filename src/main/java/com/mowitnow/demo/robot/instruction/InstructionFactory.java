package com.mowitnow.demo.robot.instruction;

import com.mowitnow.demo.robot.exception.RobotException;
import java.util.ArrayList;
import java.util.List;

public class InstructionFactory {

  public static List<Instruction> create(String format) throws RobotException {
    List<Instruction> instructions = new ArrayList<>();

    for (char instruction : format.toCharArray()) {
      instructions.add(new Instruction(instruction));
    }
    return instructions;
  }

}
