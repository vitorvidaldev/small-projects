package dev.vitorvidal.interfacesegregation;

public class Cube implements Shape, SolidShape, ShapeManager {
    @Override
    public double area() {
        return 1.0;
    }

    @Override
    public double volume() {
        return 2.0;
    }

    @Override
    public double calculate() {
        return this.area() + this.volume();
    }
}
