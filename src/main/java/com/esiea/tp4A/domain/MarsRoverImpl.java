package com.esiea.tp4A.domain;

public class MarsRoverImpl implements MarsRover{


    private Position position;

    public void MarsRover(int x,int y, Direction direction) {
        position = Position.of(x, y, direction);
    }

	@Override
	public Position move(String command) {
        if (command.isEmpty()) {
            return Position.of(0, 0, Direction.NORTH);
        }
        char singleCommand = command.charAt(0);
        if ('f' ==  singleCommand) {
            position = position.forward();
        } else if ('b' ==  singleCommand) {
            position = position.backward();
        } else if ('l' ==  singleCommand) {
            position = position.left();
        } else {
            position = position.right();
        }

        return position;
    }

}
