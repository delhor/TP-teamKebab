package com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Mars implements PlanetMap {
    private final PlanetMapImpl mapImpl;
    private Set<Position> obstacles = new HashSet<>();
    private Set<Rover> rovers = new HashSet<>();
    public int number;
    public Mars(int numberOfObstacles, int mapSize) {
        mapImpl = new PlanetMapImpl(mapSize/2, -1*((mapSize/2) - 1), mapSize/2, -1*((mapSize/2) - 1));
        this.genObstacles(numberOfObstacles);
    }
    public void genObstacles(int number) {
        if(number >= 0 ) {
            while (obstacles.size() != number) {
                Position obstacle = uniqueObstacleGen();
                obstacles.add(obstacle);
            }
        }
    }
    private Position uniqueObstacleGen(){
        FinalRandom shared = new FinalRandom();
        Point point;
        do {
            point = new Point(shared.getRandomInt(mapImpl.getMaxPositionX(), mapImpl.getMinPositionX()),shared.getRandomInt(mapImpl.getMaxPositionY(), mapImpl.getMinPositionY()),this);
        } while(detectObstacle(point.getPositionX(), point.getPositionY()));
        return new Position.FixedPosition(point.getPositionX(),point.getPositionY(),Direction.NORTH);
    }
    public boolean detectObstacle(int x, int y) {
        return Stream.concat(rovers.stream().map(Rover::getPosition),
            obstacles.stream())
            .anyMatch(p -> p.getX() == x && p.getY() == y);
    }
    public void killObstacle(int x, int y) {
        obstacles.removeIf(position -> position.getX() == x && position.getY() == y);
        rovers.removeIf(rover -> rover.getPosition().getX() == x && rover.getPosition().getY() == y);
    }
    public void generateRovers() {
        FinalRandom commons = new FinalRandom();
        for (int i = 0; i < 50 ; i++) {
            Point p = new Point(commons.getRandomInt(mapImpl.getMaxPositionX(), mapImpl.getMinPositionX()) , commons.getRandomInt(mapImpl.getMaxPositionY(), mapImpl.getMinPositionY()), this);
            addRover(new Rover(new PositionImpl(p, Direction.NORTH), this, i));
        }
    }
    public boolean addRover(Rover rover) {return rovers.add(rover);}

    public Set<Rover> getRovers() {return rovers;}

    @Override
    public Set<Position> obstaclePositions() {return obstacles;}

    public PlanetMapImpl getMapImpl() {return mapImpl;}

    public void setObstacles(Set<Position> obstacles) {this.obstacles = obstacles;}
}
