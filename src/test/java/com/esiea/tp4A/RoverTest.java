package com.esiea.tp4A;
import com.esiea.tp4A.domain.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
public class RoverTest{
    public final Mars mars = new Mars(90, 600);
    @ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,fb,0,0,NORTH",
        "0,0,SOUTH,ffl,0,-2,EAST",
        "0,0,WEST,lll,0,0,NORTH",
        "0,-299, NORTH,bbl,0,300,WEST",
        "300,0,EAST,fl,-299,0,NORTH",
        "0,0,NORTH,rr,0,0,SOUTH"
    })
    void turned_right(int positionX, int positionY, Direction dir, String commands , int expectedPositionX, int expectedPositionY, Direction expectedDir){
        Rover rover = new Rover(genPosition(positionX, positionY,dir, mars), mars);
        rover.move(commands);
        assertThat(rover.getPosition().getX()).isEqualTo(expectedPositionX);
        assertThat(rover.getPosition().getY()).isEqualTo(expectedPositionY);
        assertThat(rover.getPosition().getDirection()).isEqualTo(expectedDir);
    }
    @ParameterizedTest
    @CsvSource(value = {
        "0,300,NORTH,0,-299,f,0,300,NORTH",
        "0,300,SOUTH,0,49,f,0,300,SOUTH",
        "7,8,EAST,8,8,f,7,8,EAST",
        "0,0,WEST,-2,0,f,-1,0,WEST",
        "0,0,NORTH,0,-1,b,0,0,NORTH",
        "0,300,SOUTH,0,-299,b,0,300,SOUTH",
        "7,8,EAST,6,8,b,7,8,EAST",
        "0,0,WEST,1,0,b,0,0,WEST",
    })
    void respect_obstacles(int positionX, int positionY, Direction dir, int obstacleX, int obstacleY, String commands, int expectedPositionX, int expectedPositionY, Direction expectedDir){
        Rover rover = new Rover(genPosition(positionX, positionY,dir, mars), mars);
        mars.obstaclePositions().add(new Position.FixedPosition(obstacleX,obstacleY,Direction.NORTH));
        rover.move(commands);
        assertThat(rover.getPosition().getX()).isEqualTo(expectedPositionX);
        assertThat(rover.getPosition().getY()).isEqualTo(expectedPositionY);
        assertThat(rover.getPosition().getDirection()).isEqualTo(expectedDir);
    }
    @ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,2,0,2,sff,0,2,NORTH",
        "0,300,NORTH,2,0,-299,sf,0,-299,NORTH",
        "0,0,SOUTH,2,0,-2,sff,0,-2,SOUTH",
        "0,-299,SOUTH,2,0,300,sf,0,300,SOUTH",
        "0,0,EAST,2,2,0,sff,2,0,EAST",
        "300,0,EAST,2,-299,0,sf,-299,0,EAST",
        "0,0,WEST,2,-2,0,sff,-2,0,WEST",
        "-299,0,WEST,2,300,0,sf,300,0,WEST"
    })
    void shoot_and_move(int positionX,int positionY,Direction dir, int range, int obstacleX,int obstacleY,String commands, int expectedPositionX, int expectedPositionY, Direction expectedDir){
        mars.obstaclePositions().add(new Position.FixedPosition(obstacleX,obstacleY,Direction.NORTH));
        Rover rover = new Rover(genPosition(positionX, positionY, dir, mars), mars);
        rover.configureLaserRange(range);
        rover.move(commands);
        assertThat(rover.getPosition().getX()).isEqualTo(expectedPositionX);
        assertThat(rover.getPosition().getY()).isEqualTo(expectedPositionY);
        assertThat(rover.getPosition().getDirection()).isEqualTo(expectedDir);
    }
    @ParameterizedTest
    @CsvSource(value = {
        "1,2,NORTH",
        "-1,2,SOUTH",
        "1,-2,EAST",
        "-1,-2,WEST"
    })
    void isInit(int a, int b, Direction dir){
        Rover rover = new Rover(genPosition(0, 0,dir, mars), mars);
        Position position = genPosition(0, 0,dir, mars);
        rover.initialize(position);
        assertThat(rover.getPosition().getX() == a);
        assertThat(rover.getPosition().getY() == b);
        assertThat(rover.getPosition().getDirection() == dir);
    }
    @ParameterizedTest
    @CsvSource(value = {
        "5,100",
        "10,300",
        "15,600"
    })
    public void mapUpdated(int nbrObstacles, int size) {
        Mars m1 = new Mars(0, size);
        Mars m2 = new Mars(nbrObstacles, size);
        Rover rover = new Rover(genPosition(0, 0,Direction.NORTH, m1), m1);
        rover.updateMap(m2);
        assertThat(rover.getMars() == m2);
    }
    private Position genPosition(int positionX, int positionY, Direction dir, Mars mars) {
        Point point = new Point(positionX, positionY, mars);
        return new PositionImpl(point, dir);
    }
}
