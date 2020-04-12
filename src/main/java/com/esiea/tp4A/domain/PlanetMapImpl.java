package com.esiea.tp4A.domain;

public class PlanetMapImpl {
    private final int positionMaxX;
    private final int positionMinX;
    private final int positionMaxY;
    private final int positionMinY;
    public PlanetMapImpl(int positionMaxX, int positionMinX, int positionMaxY, int positionMinY) {
        this.positionMaxX = positionMaxX;
        this.positionMinX = positionMinX;
        this.positionMaxY = positionMaxY;
        this.positionMinY = positionMinY;
    }
    public int getMaxPositionX() {
        return positionMaxX;
    }
    public int getMinPositionX() {
        return positionMinX;
    }
    public int getMaxPositionY() {
        return positionMaxY;
    }
    public int getMinPositionY() {
        return positionMinY;
    }
}
