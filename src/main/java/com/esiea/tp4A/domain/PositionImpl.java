package com.esiea.tp4A.domain;

    public class PositionImpl implements Position {
        private final Point point;
        private Direction direction;

        public PositionImpl(Point point, Direction direction) {
            this.point = point;
            this.direction = direction;
        }

        public Direction turnLeft() {
            return direction = direction.turnLeft();
        }

        public Direction turnRight() {
            return direction = direction.turnRight();
        }


        public Point goForward() {
            switch (direction) {
                case NORTH: point.positionYForward(); break;
                case EAST: point.positionXForward(); break;
                case SOUTH: point.positionYBackward(); break;
                case WEST: point.positionXBackward(); break;
            }
            return point;
        }

        public Point goBackward() {
            switch(direction) {
                case NORTH: point.positionYBackward(); break;
                case EAST: point.positionXBackward(); break;
                case SOUTH: point.positionYForward(); break;
                case WEST: point.positionXForward(); break;
            }
            return point;
        }

        @Override
        public int getX() {
            return point.getPositionX();
        }

        @Override
        public int getY() {
            return point.getPositionY();
        }

        @Override
        public Direction getDirection() {
            return direction;
        }

    }
