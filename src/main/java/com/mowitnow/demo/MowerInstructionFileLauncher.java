package com.mowitnow.demo;

import com.mowitnow.demo.core.SequentialMowerCore;
import com.mowitnow.demo.core.exception.InitializationException;
import com.mowitnow.demo.fieldmap.FieldMap;
import com.mowitnow.demo.fieldmap.FieldMapFactory;
import com.mowitnow.demo.fieldmap.exception.FieldMapException;
import com.mowitnow.demo.robot.Robot;
import com.mowitnow.demo.robot.RobotFactory;
import com.mowitnow.demo.robot.exception.RobotException;
import com.mowitnow.demo.robot.instruction.Instruction;
import com.mowitnow.demo.robot.instruction.InstructionFactory;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MowerInstructionFileLauncher {

  private static final int BAD_USAGE = 1;
  private static final int FILE_NOT_FOUND = 2;
  private static final int FILE_BAD_FORMAT = 3;
  private static final int BAD_MAP_FORMAT = 4;
  private static final int BAD_AUTOMATON_FORMAT = 5;
  private static final int BAD_SEQUENTIAL_INITILAZE = 6;

  public static void main(String [] args) {
    if (args.length != 1) {
      exitWithMessage(BAD_USAGE, "Usage SequentialFileLauncher [file]");
    }
    String filePath = args[0];
    try {
      Path path = Paths.get(filePath);

      if (path == null) {
        exitWithMessage(FILE_NOT_FOUND, String.format("Le fichier %s n'existe pas.", filePath));
      }
      List<String> lines = Files.readAllLines(path, Charset.defaultCharset());

      if (lines.size() <= 1 || (lines.size() - 1) % 2 != 0) {
        exitWithMessage(FILE_BAD_FORMAT, "Le format du fichier n'est accepte");
      }
      try {
        FieldMap fieldMap = FieldMapFactory.create(lines.get(0));
        List<Robot> robots = new ArrayList<>();
        List<List<Instruction>> robotInstructions = new ArrayList<>();

        for(int i = 1; i < lines.size(); i += 2) {
          robots.add(RobotFactory.create(lines.get(i)));
        }
        for(int i = 2; i < lines.size(); i += 2) {
          robotInstructions.add(InstructionFactory.create(lines.get(i)));
        }
        SequentialMowerCore sequentialMower = new SequentialMowerCore(robots, fieldMap);

        sequentialMower.run(robotInstructions);

        for (Robot robot : sequentialMower.getRobots()) {
          System.out.println(robot.toString());
        }
      } catch (FieldMapException e) {
        exitWithMessage(BAD_MAP_FORMAT, e.getMessage());
      } catch (RobotException e) {
        exitWithMessage(BAD_AUTOMATON_FORMAT, e.getMessage());
      } catch (InitializationException e) {
        exitWithMessage(BAD_SEQUENTIAL_INITILAZE, e.getMessage());
      }
    } catch (IOException e) {
      exitWithMessage(FILE_NOT_FOUND, String.format("Le fichier %s n'existe pas.", filePath));
    }
  }

  private static void exitWithMessage(int exitCode, String message) {
    System.out.println(message);
    System.exit(exitCode);
  }

}
