package com.esiea.tp4A.domain;

public class Rover implements MarsRover{

    private PositionImpl position;
    private Mars mars;
    private Laser laser;
    private int id;

    public Rover(PositionImpl positionRover, Mars mars, int id) {
        this.position = positionRover;
        this.mars = mars;
        this.laser = new Laser(mars,0);
        this.id = id;
    }

    public Rover(Position generatePosition, Mars mars) {

    }

    @Override
    public MarsRover initialize(Position position) {
        Point point = new Point(position.getX(), position.getY(), mars);
        position = new PositionImpl(point, Direction.NORTH);
        return this;
    }

    @Override
    public MarsRover updateMap(PlanetMap map) {
        mars.setObstacles(map.obstaclePositions());
        return this;
    }

    @Override
    public MarsRover configureLaserRange(int range){
        laser.setRange(range);
        return null;
    }

    @Override
    public Position move(String commands){
        for (char c : commands.toCharArray()) {
            executeCommand(c);
        }
        return position;
    }

    private void executeCommand(char command) {
        switch(command) {
            case 'l': position.turnLeft(); break;
            case 'r': position.turnRight(); break;
            case 'f': position.goForward(); break;
            case 'b': position.goBackward(); break;
            case 's': shoot(); break;
        }
    }

    public Position getPosition() {
        return position;
    }
    public Mars getMars() { return mars; }
    public void shoot(){
        laser.shoot(position,position.getDirection());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
