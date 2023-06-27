package dev.vitorvidal.interfacesegregation;

public class Square implements Shape, ShapeManager {
    @Override
    public double area() {
        return 4.0;
    }

    @Override
    public double calculate() {
        return this.area();
    }
}
