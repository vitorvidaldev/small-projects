package dev.vitorvidal;

import dev.vitorvidal.display.Monitor;
import dev.vitorvidal.display.Projector;

public class App {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setDisplayModule(new Monitor());
        computer.display();

        computer.setDisplayModule(new Projector());
        computer.display();
    }
}
