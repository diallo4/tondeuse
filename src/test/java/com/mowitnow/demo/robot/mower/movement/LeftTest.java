package com.mowitnow.demo.robot.mower.movement;

import static org.assertj.core.api.Assertions.assertThat;

import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LeftTest {

  @Test
  public void givenDirectedPosition1x1NWhenTurnLeftThenGetDirectedPosition1x1W() {
    // Given
    DirectedPosition orientedPosition1x1N = new DirectedPosition(Direction.N, new Position(1, 1));
    Left moveLeft = new Left();

    // When
    DirectedPosition directedPosition = moveLeft.executeFrom(orientedPosition1x1N);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(1);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(1);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.W);
  }

  @Test
  public void givenDirectedPosition1x1OWhenTurnLeftThenGetDirectedPosition1x1S() {
    // Given
    DirectedPosition orientedPosition1x1W = new DirectedPosition(Direction.W, new Position(1, 1));
    Left moveLeft = new Left();

    // When
    DirectedPosition directedPosition = moveLeft.executeFrom(orientedPosition1x1W);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(1);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(1);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void givenDirectedPosition1x1SWhenTurnLeftThenGetDirectedPosition1x1E() {
    // Given
    DirectedPosition orientedPosition1x1S = new DirectedPosition(Direction.S, new Position(1, 1));
    Left moveLeft = new Left();

    // When
    DirectedPosition directedPosition = moveLeft.executeFrom(orientedPosition1x1S);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(1);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(1);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void givenDirectedPosition1x1EWhenTurnLeftThenGetDirectedPosition1x1N() {
    // Given
    DirectedPosition orientedPosition1x1E = new DirectedPosition(Direction.E, new Position(1, 1));
    Left moveLeft = new Left();

    // When
    DirectedPosition directedPosition = moveLeft.executeFrom(orientedPosition1x1E);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(1);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(1);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.N);
  }

}