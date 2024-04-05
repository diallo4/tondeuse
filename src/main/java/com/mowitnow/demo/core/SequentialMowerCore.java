package com.mowitnow.demo.core;

import com.mowitnow.demo.core.exception.InitializationException;
import com.mowitnow.demo.fieldmap.FieldMap;
import com.mowitnow.demo.robot.Robot;
import com.mowitnow.demo.robot.instruction.Instruction;
import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Position;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialMowerCore {

  private static final Logger logger = LoggerFactory.getLogger(SequentialMowerCore.class);

  private List<Robot> robots;
  private FieldMap fieldMap;

  public SequentialMowerCore(List<Robot> robots, FieldMap fieldMap) throws InitializationException {
    this.robots = robots;
    this.fieldMap = fieldMap;
    for (Robot robot : robots) {
      if (!fieldMap.accept(robot.getPosition())) {
        throw new InitializationException(String.format("%s ne peut se trouver dans %s", robot, fieldMap));
      }
      if (isThereRobotHere(robot, robot.getPosition())) {
        throw new InitializationException(String.format("%s se trouve a la meme position qu'un autre automate", robot));
      }
    }
  }

  public void run(List<List<Instruction>> instructions) throws InitializationException {
    if (this.robots.size() < instructions.size()) {
      throw new InitializationException("Il y a plus d'actions que d'automates.");
    }
    int i = 0;

    while (i < instructions.size()) {
      Robot robot = robots.get(i);
      List<Instruction> robotInstructions = instructions.get(i);
      logger.info("Debut de sequence {}: {}", robot, robotInstructions);
      runAutomatonSequence(robot, robotInstructions);
      logger.info("Fin de sequence {}", robot);
      i++;
    }
  }

  private void runAutomatonSequence(Robot robot, List<Instruction> instructions) {
    for (Instruction instruction : instructions) {
      DirectedPosition nextDirectedPosition = robot.dryRun(instruction);
      if (fieldMap.accept(nextDirectedPosition.getPosition())) {
        if (!isThereRobotHere(robot, nextDirectedPosition.getPosition())) {
          robot.run(instruction);
        }
        else {
          logger.info("Il y a deja un automate a cette place.");
        }
      }
      else {
        logger.info("La carte n'accepte pas cette action.");
      }
    }
  }

  private boolean isThereRobotHere(Robot toExclude, Position position) {
    for (Robot robot : robots) {
      if (robot != toExclude && robot.getPosition().equals(position))
        return true;
    }
    return false;
  }

  public List<Robot> getRobots() {
    return this.robots;
  }

}
