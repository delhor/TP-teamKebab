package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.esiea.tp4A.Direction.NORTH;
import static org.assertj.core.api.Assertions.assertThat;

public class LaserTest {
        public final Mars mars = new Mars(20, 600);
        Laser laser = new Laser(mars, 0);

        @ParameterizedTest
        @CsvSource({
            "0, 0, 3, 0, NORTH, EAST,5, False, True",
            "0, 0, 5, 0, NORTH, EAST,5, False, True",
            "0, 0, 24, 0, NORTH, EAST,5, True, True",
            "0, 0, 8, 3, NORTH, EAST,5, True, True"
        })
        void shotEast(int positionX, int positionY, int obstacleX, int obstacleY, Direction dir, Direction dirShoot, int range, boolean expectedIsObs, boolean expectedIsObsN){
            PositionImpl position = new PositionImpl(new Point(positionX, positionY,mars), NORTH);
            laser.setRange(range);
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX,obstacleY,dir));
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX+1,obstacleY,dir));
            laser.shoot(position, dirShoot);
            assertThat(mars.detectObstacle(obstacleX, obstacleY)).isEqualTo(expectedIsObs);
            assertThat(mars.detectObstacle(obstacleX+1, obstacleY)).isEqualTo(expectedIsObsN);
        }

        @ParameterizedTest
        @CsvSource({
            "0, 0, -4, 0, NORTH, WEST,5, False, True",
            "0, 0, -3, 0, NORTH, WEST,5, False, True",
            "0, 0, -8, 0, NORTH, WEST,5, True, True",
            "0, 0, 2, 1, NORTH, WEST,5, True, True"
        })
        void shotWest(int positionX, int positionY, int obstacleX, int obstacleY, Direction dir, Direction dirShoot, int range, boolean expectedIsObs, boolean expectedIsObsN){
            PositionImpl position = new PositionImpl(new Point(positionX, positionY,mars), NORTH);
            laser.setRange(range);
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX,obstacleY,dir));
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX-1,obstacleY,dir));
            laser.shoot(position, dirShoot);
            assertThat(mars.detectObstacle(obstacleX, obstacleY)).isEqualTo(expectedIsObs);
            assertThat(mars.detectObstacle(obstacleX-1, obstacleY)).isEqualTo(expectedIsObsN);
        }

        @ParameterizedTest
        @CsvSource({
            "0, 0, 0, 4, NORTH, NORTH,5, False, True",
            "0, 0, 0, 3, NORTH, NORTH,5, False, True",
            "0, 0, 0, 8, NORTH, NORTH,5, True, True",
            "0, 0, 1, 2, NORTH, NORTH,5, True, True",
        })
        void shotNorth(int positionX, int positionY, int obstacleX, int obstacleY, Direction dir, Direction dirShoot, int range, boolean expectedIsObs, boolean expectedIsObsN){
            PositionImpl position = new PositionImpl(new Point(positionX, positionY,mars), NORTH);
            laser.setRange(range);
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX,obstacleY,dir));
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX+1,obstacleY,dir));
            laser.shoot(position, dirShoot);
            assertThat(mars.detectObstacle(obstacleX, obstacleY)).isEqualTo(expectedIsObs);
            assertThat(mars.detectObstacle(obstacleX+1, obstacleY)).isEqualTo(expectedIsObsN);
        }


        @ParameterizedTest
        @CsvSource({
            "0, 0, 0, -4, NORTH, SOUTH,5, False, True",
            "0, 0, 0, -3, NORTH, SOUTH,5, False, True",
            "0, 0, 0, -8, NORTH, SOUTH,5, True, True",
            "0, 0, 1, -16, NORTH, SOUTH,5, True, True"
        })
        void shotSouth(int positionX, int positionY, int obstacleX, int obstacleY, Direction dir, Direction dirShoot, int range, boolean expectedIsObs, boolean expectedIsObsN){
            PositionImpl position = new PositionImpl(new Point(positionX, positionY,mars), NORTH);
            laser.setRange(range);
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX,obstacleY,dir));
            mars.obstaclePositions().add(new Position.FixedPosition(obstacleX-1,obstacleY,dir));
            laser.shoot(position, dirShoot);
            assertThat(mars.detectObstacle(obstacleX, obstacleY)).isEqualTo(expectedIsObs);
            assertThat(mars.detectObstacle(obstacleX-1, obstacleY)).isEqualTo(expectedIsObsN);
        }
    }
