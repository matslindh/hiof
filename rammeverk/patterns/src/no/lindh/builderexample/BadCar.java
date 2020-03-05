package no.lindh.builderexample;

public class BadCar {
    int seats = 4;
    int doors = 2;
    int wheels = 3;

    boolean hasEngine;
    boolean isLocked;

    // We have to provide all values, even if we only want to change the default hasEngine value
    BadCar(int seats, int doors, int wheels, boolean hasEngine, boolean isLocked) {
        this.seats = seats;
        this.doors = doors;
        this.wheels = wheels;
        this.hasEngine = hasEngine;
        this.isLocked = isLocked;
    }
}
