package dev.vitorvidal.liskovsubstitution;

public class Bus extends Vehicle {
    @Override
    public int getSpeed() {
        return 70;
    }

    @Override
    public int getCubicCapacity() {
        return 50000;
    }

    public int getNumberOfPassengers() {
        return 40;
    }
}
