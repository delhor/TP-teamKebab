package com.esiea.tp4A;

public class Point {
    public int positionX;
    public int positionY;
    public final Obstacle obstacle;

    public Point(int positionX, int positionY, Mars mars){
        this.positionX = positionX;
        this.positionY = positionY;
        this.obstacle = mars;
    }

    public void positionXForward(){
        int positionTest = (positionX + 1) > obstacle.maxpositionX ? obstacle.minpositionX : positionX + 1;
        if(!obstacle.checkIfObstacle(positionTest,positionY)) {
            positionX = positionTest;
        }
    }

    public void positionXBackward(){
        int positionTest = (positionX - 1) < obstacle.minpositionX ? obstacle.maxpositionX : positionX - 1;
        if(!obstacle.checkIfObstacle(positionTest,positionY)) {
            positionX = positionTest;
        }
    }
    public void positionYForward(){
        int positionTest = (positionY + 1) > obstacle.maxpositionY ? obstacle.minpositionY : positionY + 1;
        if(!obstacle.checkIfObstacle(positionX ,positionTest)) {
            positionY = positionTest;
        }
    }
    public void positionYBackward(){
        int positionTest = (positionY - 1) < obstacle.minpositionY ? obstacle.maxpositionY : positionY - 1;
        if(!obstacle.checkIfObstacle(positionX ,positionTest)) {
            positionY = positionTest;
        }
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
