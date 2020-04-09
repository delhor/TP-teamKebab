package com.esiea.tp4A.domain;

public class Point {
    private int positionX;
    private int positionY;
    private final Obstacle obstacle;

    public Point(int positionX, int positionY, Obstacle mars){
        this.positionX = positionX;
        this.positionY = positionY;
        this.obstacle = mars;
    }

    public void positionXForward(){
        int positionTest = (positionX + 1) > obstacle.positionMaxX ? obstacle.positionMinX : positionX + 1;
        if(!obstacle.obstacleDetection(positionTest,positionY)) {
            positionX = positionTest;
        }
    }

    public void positionXBackward(){
        int positionTest = (positionX - 1) < obstacle.positionMinX ? obstacle.positionMaxX : positionX - 1;
        if(!obstacle.obstacleDetection(positionTest,positionY)) {
            positionX = positionTest;
        }
    }
    public void positionYForward(){
        int positionTest = (positionY + 1) > obstacle.positionMaxY ? obstacle.positionMinY : positionY + 1;
        if(!obstacle.obstacleDetection(positionX ,positionTest)) {
            positionY = positionTest;
        }
    }
    public void positionYBackward(){
        int positionTest = (positionY - 1) < obstacle.positionMinY ? obstacle.positionMaxY : positionY - 1;
        if(!obstacle.obstacleDetection(positionX ,positionTest)) {
            positionY = positionTest;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getpositionY() {
        return positionY;
    }




    @Override
    public String toString() {
        return "Point{" +
            "positionX=" + positionX +
            ", positionY=" + positionY +
            ", obstacle=" + obstacle +
            '}';
    }
}
