package com.mowitnow.demo.robot.mower;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.mowitnow.demo.robot.exception.InstructionException;
import com.mowitnow.demo.robot.instruction.Instruction;
import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MowerTest {

  @Test
  public void givenALawnMoverAt2x2NWhenDryRunActionAThenReturnOrientedPosition2x3N() {
    // Given
    Position position2x2 = new Position(2, 2);
    Direction orientationN = Direction.N;
    Mower lawnMoverAt2x2N = new Mower(position2x2, orientationN);
    Instruction actionA = new Instruction('A');

    // When
    DirectedPosition tested = lawnMoverAt2x2N.dryRun(actionA);

    // Then
    assertThat(tested.getDirection()).isEqualTo(Direction.N);
    assertThat(tested.getPosition().getX()).isEqualTo(2);
    assertThat(tested.getPosition().getY()).isEqualTo(3);
  }

  @Test
  public void givenALawnMoverAt2x2NWhenDryRunActionUnknowThenThrowActionNotFound() {
    // Given
    Position position2x2 = new Position(2, 2);
    Direction orientationN = Direction.N;
    Mower lawnMoverAt2x2N = new Mower(position2x2, orientationN);
    Instruction actionUnknow = new Instruction('B');

    // When
    assertThatExceptionOfType(InstructionException.class).isThrownBy(() -> lawnMoverAt2x2N.dryRun(actionUnknow));
  }

  @Test
  public void givenALawnMoverAt2x2NWhenRunActionAThenLawnMoverAt2x3N() {
    Position position2x2 = new Position(2, 2);
    Direction orientationN = Direction.N;
    Mower lawnMoverAt2x2N = new Mower(position2x2, orientationN);
    Instruction actionA = new Instruction('A');
    Position position2x3 = new Position(2, 3);

    lawnMoverAt2x2N.run(actionA);

    assertThat(lawnMoverAt2x2N.getPosition()).isEqualTo(position2x3);
    assertThat(lawnMoverAt2x2N.getDirection()).isEqualTo(Direction.N);
  }

}