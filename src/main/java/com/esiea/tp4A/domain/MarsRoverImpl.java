package com.esiea.tp4A.domain;

public class MarsRoverImpl implements MarsRover{

    private int x;
    private int y;
    private Direction direction;
    private Obstacle obstacle;

    public MarsRoverImpl() {
    }

    @Override
    public  MarsRover initialize(Position pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.direction = pos.getDir();
        this.direction = pos.getDir();
        return this;
    }
    @Override
    public MarsRover updateMap(PlanetMap obstacle){
        this.obstacle = (Obstacle) obstacle;
        return this;
    }
    @Override
    public MarsRover configureLaserRange(int range){
        return null;
    }
	@Override
	public Position move(String command) {
        if (command.isEmpty()) {
            return Position.of(0, 0, Direction.NORTH);
        }
        char singleCommand = command.charAt(0);
        if (('f' ==  singleCommand)&&(direction==Direction.NORTH)) { this.y += 1; }
        else if(('f' ==  singleCommand)&&(direction==Direction.SOUTH)){ this.y -= 1; }
        else if (('f' ==  singleCommand) &&(direction==Direction.WEST)) { this.x -= 1; }
        else {this.x += 1;}
        if (('b' ==  singleCommand)&&(direction==Direction.NORTH)) { this.y -= 1; }
        else if(('b' ==  singleCommand)&&(direction==Direction.SOUTH)){ this.y += 1; }
        else if (('b' ==  singleCommand) &&(direction==Direction.WEST)) { this.x += 1; }
        else {this.x -= 1;}
        if (('l' ==  singleCommand)&&(direction==Direction.NORTH)) { this.direction = Direction.WEST; }
        else if(('l' ==  singleCommand)&&(direction==Direction.SOUTH)){ this.direction = Direction.EAST; }
        else if (('l' ==  singleCommand) &&(direction==Direction.WEST)) { this.direction = Direction.SOUTH; }
        else {this.direction = Direction.NORTH;}
        if (('r' ==  singleCommand)&&(direction==Direction.NORTH )){ this.direction = Direction.EAST;}
        else if(('r' ==  singleCommand)&&(direction==Direction.SOUTH)){ this.direction = Direction.WEST;}
        else if (('r' ==  singleCommand) &&(direction==Direction.WEST)) { this.direction = Direction.NORTH;}
        else {this.direction = Direction.SOUTH;}

        return Position.of(x,y,direction);
    }
}
