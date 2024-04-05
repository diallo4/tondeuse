package com.mowitnow.demo.robot.mower.movement;

import com.mowitnow.demo.robot.mower.direction.DirectedPosition;

public interface Movement {
    DirectedPosition executeFrom(DirectedPosition directedPosition);
}
