package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Mars;
import com.esiea.tp4A.domain.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsTest {
    Mars test = new Mars(0, 100);
    @ParameterizedTest
    @CsvSource({
        "0,0",
        "4,4",
        "2,2",
        "-5,0"
    })
    void correct_number_obstacles(int numberOfObstacles,int expectedNumber){
        test.genObstacles(numberOfObstacles);
        assertThat(test.obstaclePositions().size()).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "0,0,0,0,true",
        "4,4,5,5,false",
        "-7,6,-7,-6,false",
        "-9,-9,-9,-9,true",
        "-3,8,-3,8,true"
    })
    void obstacle_exist(int x,int y,int resultX,int resultY,boolean expected){
        test.genObstacles(0);
        test.obstaclePositions().add(new Position.FixedPosition(x,y, Direction.NORTH));
        assertThat(test.detectObstacle(resultX,resultY)).isEqualTo(expected);
    }
}
