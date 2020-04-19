package com.esiea.tp4A;

public class Point {
    private int positionX;
    private int positionY;
    private final Mars mapImpl;
    public Point(int positionX, int positionY, Mars mars){
        this.positionX = positionX; this.positionY = positionY; this.mapImpl = mars;
    }
    public boolean positionXForward(){
        int positionTest = getPositionXForward();
        if(!mapImpl.detectObstacle(positionTest,positionY)) {
            positionX = positionTest;
            return true;
        }
        return false;
    }
    public boolean positionXBackward(){
        int positionTest = getPositionXBackward();
        if(!mapImpl.detectObstacle(positionTest,positionY)) {
            positionX = positionTest;
            return true;
        }
        return false;
    }
    public boolean positionYForward(){
        int positionTest = getPositionYForward();
        if(!mapImpl.detectObstacle(positionX ,positionTest)) {
            positionY = positionTest;
            return true;
        }
        return false;
    }
    public boolean positionYBackward(){
        int positionTest = getPositionYBackward();
        if(!mapImpl.detectObstacle(positionX ,positionTest)) {
            positionY = positionTest;
            return true;
        }
        return false;
    }
    public int getPositionXForward(){
        return (positionX + 1) > mapImpl.getMapImpl().getMaxPositionX() ? mapImpl.getMapImpl().getMinPositionX() : positionX + 1;
    }
    public int getPositionXBackward(){
        return (positionX - 1) < mapImpl.getMapImpl().getMinPositionX() ? mapImpl.getMapImpl().getMaxPositionX() : positionX - 1;
    }
    public int getPositionYForward(){
        return (positionY + 1) > mapImpl.getMapImpl().getMaxPositionY() ? mapImpl.getMapImpl().getMinPositionY() : positionY + 1;
    }
    public int getPositionYBackward(){
        return (positionY - 1) < mapImpl.getMapImpl().getMinPositionY() ? mapImpl.getMapImpl().getMaxPositionY() : positionY - 1;
    }
    public int getPositionY() { return positionY; }
    public int getPositionX() { return positionX; }
}

