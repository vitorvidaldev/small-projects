package dev.vitorvidal.delegation;

public class Printer {
    PhysicalPrinter physicalPrinter = new PhysicalPrinter();

    public void print() {
        physicalPrinter.print();
    }
}
