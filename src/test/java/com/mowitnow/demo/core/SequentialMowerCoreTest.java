package com.mowitnow.demo.core;


import static org.assertj.core.api.Assertions.assertThat;

import com.mowitnow.demo.fieldmap.FieldMap;
import com.mowitnow.demo.fieldmap.FieldMapFactory;
import com.mowitnow.demo.robot.Robot;
import com.mowitnow.demo.robot.RobotFactory;
import com.mowitnow.demo.robot.exception.RobotException;
import com.mowitnow.demo.robot.instruction.InstructionFactory;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SequentialMowerCoreTest {

  Position position1x3 = new Position(1, 3);
  Position position5x1 = new Position(5, 1);

  @Test
  public void givenMap5x52AutomatonsWhenRunThen() throws RobotException {
    FieldMap rectangularMap5x5 = FieldMapFactory.create("5 5");
    Robot lawnMover1x2N = RobotFactory.create("1 2 N");
    Robot lawnMover3x3E = RobotFactory.create("3 3 E");
    SequentialMowerCore sequentialCentral = new SequentialMowerCore(Arrays.asList(lawnMover1x2N, lawnMover3x3E), rectangularMap5x5);

    sequentialCentral.run(Arrays.asList(InstructionFactory.create("GAGAGAGAA"), InstructionFactory.create("AADAADADDA")));

    assertThat(lawnMover1x2N.getPosition()).isEqualTo(position1x3);
    assertThat(lawnMover1x2N.getDirection()).isEqualTo(Direction.N);

    assertThat(lawnMover3x3E.getPosition()).isEqualTo(position5x1);
    assertThat(lawnMover3x3E.getDirection()).isEqualTo(Direction.E);
  }

}