package com.mowitnow.demo.robot.mower.movement;

import static org.assertj.core.api.Assertions.assertThat;

import com.mowitnow.demo.robot.mower.direction.DirectedPosition;
import com.mowitnow.demo.robot.mower.direction.Direction;
import com.mowitnow.demo.robot.mower.direction.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ForwardTest {

  @Test
  public void givenDirectedPosition1x1NWhenMovingFowardThenGetDirectedPosition1x2N() {
    // Given
    DirectedPosition orientedPosition1x1N = new DirectedPosition(Direction.N, new Position(1, 1));
    Forward moveForward = new Forward();

    // When
    DirectedPosition directedPosition = moveForward.executeFrom(orientedPosition1x1N);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(1);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(2);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.N);

  }

  @Test
  public void givenDirectedPosition1x1EWhenMovingFowardThenGetDirectedPosition2x1E() {
    // Given
    DirectedPosition orientedPosition1x1E = new DirectedPosition(Direction.E, new Position(1, 1));
    Forward moveForward = new Forward();

    // When
    DirectedPosition directedPosition = moveForward.executeFrom(orientedPosition1x1E);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(2);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(1);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.E);
  }

  @Test
  public void givenDirectedPosition1x1SWhenMovingFowardThenGetDirectedPosition1x0S() {
    // Given
    DirectedPosition orientedPosition1x1S = new DirectedPosition(Direction.S, new Position(1, 1));
    Forward moveForward = new Forward();

    // When
    DirectedPosition directedPosition = moveForward.executeFrom(orientedPosition1x1S);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(1);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(0);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.S);
  }

  @Test
  public void givenDirectedPosition1x1OWhenMovingFowardThenGetDirectedPosition0x1O() {

    // Given
    DirectedPosition orientedPosition1x1W = new DirectedPosition(Direction.W, new Position(1, 1));
    Forward moveForward = new Forward();

    // When
    DirectedPosition directedPosition = moveForward.executeFrom(orientedPosition1x1W);

    // Then
    assertThat(directedPosition.getPosition().getX()).isEqualTo(0);
    assertThat(directedPosition.getPosition().getY()).isEqualTo(1);
    assertThat(directedPosition.getDirection()).isEqualTo(Direction.W);
  }

}