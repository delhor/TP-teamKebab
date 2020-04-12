package com.esiea.tp4A.domain;

public class Laser {
    private final Mars mars;
    private int range;

    public Laser(Mars mars, int range) {
        this.mars = mars;
        this.range = range;
    }

    //todo : détruire les rovers
    public void shoot(PositionImpl pos, Direction dir){
        switch (dir) {
            case NORTH:
                shootN(pos); break;
            case SOUTH:
                shootS(pos); break;
            case EAST:
                shootE(pos); break;
            case WEST:
                shootW(pos); break;
        }
    }

    private void shootN(PositionImpl pos) {
        Point p = new Point(pos.getX(),pos.getY(),mars);
        for(int i = 0 ; i < this.range ; i++){
            if(!p.positionYForward()){
                this.mars.killObstacle(p.getPositionX(),p.getPositionYForward());
                break;
            }
        }
    }
    private void shootS(PositionImpl pos) {
        Point p = new Point(pos.getX(),pos.getY(),mars);
        for(int i = 0 ; i < this.range ; i++){
            if(!p.positionYBackward()){
                this.mars.killObstacle(p.getPositionX(),p.getPositionYBackward());
                break;
            }
        }
    }
    private void shootE(PositionImpl pos) {
        Point p = new Point(pos.getX(),pos.getY(),mars);
        for(int i = 0 ; i < this.range ; i++){
            if(!p.positionXForward()){
                this.mars.killObstacle(p.getPositionXForward(),p.getPositionY());
                break;
            }
        }
    }
    private void shootW(PositionImpl pos) {
        Point point = new Point(pos.getX(),pos.getY(),mars);
        for(int i = 0 ; i < this.range ; i++){
            if(!point.positionXBackward()){
                this.mars.killObstacle(point.getPositionXBackward(),point.getPositionY());
                break;
            }
        }
    }

    public void setRange(int range) {
        this.range = range;
    }
}
