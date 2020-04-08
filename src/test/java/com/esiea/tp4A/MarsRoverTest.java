package com.github.ledoyen.korekto.core.thirdparty.tp4a2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverTest {

    @ParameterizedTest
    @CsvSource({
        "'', 0, 0, NORTH",
        "f, 0, 1, NORTH",
        "b, 0, -1, NORTH",
        "l, 0, 0, WEST",
        "r, 0, 0, EAST",
        "ff, 0, 2, NORTH",
        "lf, -1, 0, WEST",
        "rf, 1, 0, EAST",
        "llf, 0, -1, SOUTH",
        "bb, 0, -2, NOTH",
        "lb, 1, 0, WEST",
        "llb, 0, 1, SOUTH",
        "rb, 0, -2,EAST",
        "bb, 0 -2 NORTH",
    })

    void rover_stays_at_initial_position(String command, int expectedX,int expectedY,Direction expectedDirection);
    MarsRover marsRover = new MarsRoverImpl(x:0, y:0 ,Direction.NORTH);
    Position newPosition = marsRover.move(command);

	Assertions.assertThat(newPosition)
        is.EqualTo(Position.of(expectedX, expectedy, expectedDirection));

.
}
