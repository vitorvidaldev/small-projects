package dev.vitorvidal.liskovsubstitution;

public class Car extends Vehicle {

    @Override
    public int getSpeed() {
        return 100;
    }

    @Override
    public int getCubicCapacity() {
        return 30000;
    }

    public int getNumberOfWheels() {
        return 4;
    }
}
