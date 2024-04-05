package com.mowitnow.demo.core;

import com.mowitnow.demo.robot.Robot;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RobotInstructions {

  private Robot robot;
  private String instructions;

}
