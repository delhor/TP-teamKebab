package com.esiea.tp4A.domain;

import java.util.Set;
import java.util.HashSet;

public class Obstacle {
        public Set<Position> obstacles = new HashSet<>();
        public final int positionMaxX;
        public final int positionMaxY;
        public final int positionMinX;
        public final int positionMinY;

        public Obstacle(int obstaclesNumber) {
            this.positionMaxX = 50;
            this.positionMaxY = 50;
            this.positionMinX = -49;
            this.positionMinY = -49;
            this.obstaclesGenerate(obstaclesNumber);

        }

        public void obstaclesGenerate(int number) {
            if(number >= 0 ) {
                while (obstacles.size() != number) {
                    Position obstacle = uniqueObstacleGenerate();
                    obstacles.add(obstacle);
                }
            }
        }

        private Position uniqueObstacleGenerate(){
            finalRandom finalrandom = new finalRandom();
            Point p = new Point(finalrandom.getRandomInt(positionMaxX,positionMinX),finalrandom.getRandomInt(positionMaxY,positionMinY),this);
            return new Position.FixedPosition(p.getPositionX(),p.getpositionY(),Direction.NORTH);
        }

        public boolean detectObstacle(int x, int y) {
                return obstacles.stream()
                    .anyMatch(p -> p.getX() == x && p.getY() == y);
            }

        public void killObstacle(int x, int y) {
            obstacles.removeIf(position -> position.getX() == x && position.getY() == y);
        }

        public Set<Position> obstaclePositions() {
            return obstacles;
        }
    }
