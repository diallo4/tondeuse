package com.mowitnow.demo.robot;

import com.mowitnow.demo.robot.exception.InvalidDirectionException;
import com.mowitnow.demo.robot.exception.RobotException;
import com.mowitnow.demo.robot.mower.Mower;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotFactory {

  private static final Pattern lawnMowerPattern = Pattern.compile("(\\d+) (\\d+) ([NESO])");

  public static Robot create(String format) throws RobotException {
    Matcher lawnMowerMatcher = lawnMowerPattern.matcher(format);
    if (lawnMowerMatcher.matches()) {
      int x = Integer.valueOf(lawnMowerMatcher.group(1));
      int y = Integer.valueOf(lawnMowerMatcher.group(2));
      char orientation = lawnMowerMatcher.group(3).charAt(0);
      try {
        return new Mower(new Position(x, y), new Direction(orientation));
      } catch (InvalidDirectionException e) {
        throw new RobotException("Orientation invalide lors de la creation d'une tondeuse");
      }
    }
    else {
      throw new RobotException("Le format du robot n'est pas connu.");
    }
  }

}
