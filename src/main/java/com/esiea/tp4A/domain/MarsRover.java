package com.esiea.tp4A.domain;

import com.esiea.tp4A.Direction;

public interface MarsRover {

    default MarsRover initialize(Position position) {
        return this;
    }

    default MarsRover updateMap(PlanetMap map) {
        return this;
    }

    default MarsRover configureLaserRange(int range) {
        return this;
    }

    default Position move(String command) {
        return Position.of(0, 0, Direction.NORTH);
    }
}
