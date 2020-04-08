package com.esiea.tp4A.domain;

public interface Position {

    int getX();
    int getY();
    Direction getDirection();

    static Position of(int x, int y, Direction direction) {
        return new FixedPosition(x, y, direction);
    }

    final class FixedPosition implements Position {

        private final int x;
        private final int y;
        private final Direction direction;

        public FixedPosition(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public Direction getDirection() {
            return direction;
        }

        @Override
        public Position forward() {
            switch (direction) {
                case NORTH:
                    return Position.of(x, y+1, Direction.NORTH);
                case SOUTH:
                    return Position.of(x, y-1, Direction.SOUTH));
                case WEST:
                    return Position.of(x-1, y, Direction.WEST));
                case EAST:
                    return Position.of(x+1, y, Direction.EAST));
            }
            throw new IllegalStateException("Pas de direction: " + direction);
        }

        @Override
        public Position backward() {
            return Position.of(x, y-1, direction);
        }

        @Override
        public Position left() {
            return Position.of(x-1, y, direction);
        }

        @Override
        public Position right() {
            return Position.of(x+1, y, direction);
        }

    }
}
