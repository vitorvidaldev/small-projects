package dev.vitorvidal;

import dev.vitorvidal.delegation.Printer;
import dev.vitorvidal.display.Monitor;
import dev.vitorvidal.display.Projector;
import dev.vitorvidal.liskovsubstitution.Bus;
import dev.vitorvidal.liskovsubstitution.Car;
import dev.vitorvidal.liskovsubstitution.Vehicle;
import dev.vitorvidal.openclosed.AreaCalculator;
import dev.vitorvidal.openclosed.Circle;
import dev.vitorvidal.openclosed.Rectangle;
import dev.vitorvidal.openclosed.Shape;
import dev.vitorvidal.singleresponsibility.Employee;
import dev.vitorvidal.singleresponsibility.Finance;
import dev.vitorvidal.singleresponsibility.HRPromotions;

public class App {
    public static void main(String[] args) {
//        programmingToAnInterfaceExample();
//        delegationExample();
//        singleResponsibilityExample();
//        openClosedExample();

        liskovSubstitutionExample();
    }

    private static void liskovSubstitutionExample() {
        Vehicle car = new Car();
        System.out.println("Car speed: " + car.getSpeed());

        Vehicle bus = new Bus();
        System.out.println("Bus speed: " + bus.getSpeed());
    }

    private static void openClosedExample() {
        Shape circle = new Circle(2.0);
        Shape rectangle = new Rectangle(2.0, 2.0);

        AreaCalculator areaCalculator = new AreaCalculator();

        double circleArea = areaCalculator.calculateShapeArea(circle);
        System.out.println("Circle area: " + circleArea);
        double rectangleArea = areaCalculator.calculateShapeArea(rectangle);
        System.out.println("Rectangle area: " + rectangleArea);
    }

    private static void singleResponsibilityExample() {
        Employee employee = new Employee();
        HRPromotions hrPromotions = new HRPromotions();
        boolean goingToBePromoted = hrPromotions.isPromotionDueThisYear(employee);
        System.out.println("Employee promotion status: " + goingToBePromoted);
        Finance finance = new Finance();
        double incomeTax = finance.calculateIncomeTaxForCurrentYear(employee);
        System.out.println("Employee income tax: " + incomeTax);
    }

    private static void delegationExample() {
        Printer printer = new Printer();
        printer.print();
    }

    private static void programmingToAnInterfaceExample() {
        Computer computer = new Computer();
        computer.setDisplayModule(new Monitor());
        computer.display();

        computer.setDisplayModule(new Projector());
        computer.display();
    }
}
