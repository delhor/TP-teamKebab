package com.esiea.tp4A.domain;

public class Laser {
    public final Obstacle obstacle;
    public final int distMax;

    public Laser(Obstacle obstacle, int distMax){
        this.obstacle = obstacle;
        this.distMax = distMax;
    }

    public void shoot(Position pos, Direction dir){
        switch(dir){
            case NORTH:shootNorth(pos); break;
            case EAST:shootEast(pos); break;
            case SOUTH:shootSouth(pos); break;
            case WEST:shootWest(pos); break;
        }
    }

    private void shootNorth(Position pos){
        for(int count = pos.getY(); count < pos.getY()+ this.distMax; count++){
            if(this.obstacle.detectObstacle(pos.getX(), count)){
                this.obstacle.killObstacle(pos.getX(), count);
            }
        }
    }

    private void shootEast(Position pos){
        for(int count = pos.getY(); count > pos.getY()+ this.distMax; count++){
            if(this.obstacle.detectObstacle(pos.getY(), count)){
                this.obstacle.killObstacle(pos.getY(), count);
            }
        }
    }

    private void shootSouth(Position pos){
        for(int count = pos.getX(); count < pos.getX()+ this.distMax; count--){
            if(this.obstacle.detectObstacle(pos.getX(), count)){
                this.obstacle.killObstacle(pos.getX(), count);
            }
        }
    }

    private void shootWest(Position pos){
        for(int i = pos.getY(); i > pos.getY()+ this.distMax; i--){
            if(this.obstacle.detectObstacle(pos.getY(), i)){
                this.obstacle.killObstacle(pos.getY(), i);
            }
        }
    }
}
