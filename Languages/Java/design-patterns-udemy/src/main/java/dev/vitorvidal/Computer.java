package dev.vitorvidal;

import dev.vitorvidal.display.DisplayModule;

public class Computer {
    DisplayModule displayModule;

    public void setDisplayModule(DisplayModule displayModule) {
        this.displayModule = displayModule;
    }

    public void display() {
        displayModule.display();
    }
}
