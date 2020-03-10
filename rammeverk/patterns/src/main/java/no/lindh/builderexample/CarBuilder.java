package no.lindh.builderexample;

// This can be refactored to an interface to build different types of objects from the same set of instructions
// -- see the "Director" role in the pattern if that's the case.
public class CarBuilder {
    private Car car = new Car();

    public CarBuilder seats(int seats) {
        car.seats = seats;
        return this;
    }

    public CarBuilder doors(int doors) {
        car.doors = doors;
        return this;
    }

    public CarBuilder isLocked() {
        car.isLocked = true;
        return this;
    }

    public CarBuilder hasEngine() {
        car.hasEngine = true;
        return this;
    }

    public CarBuilder hasNoEngine() {
        car.hasEngine = false;
        return this;
    }

    public Car car() {
        return car;
    }

    public void reset() {
        this.car = new Car();
    }
}

class Car {
     int seats = 4;
     int doors = 2;

     boolean hasEngine = true;
     boolean isLocked = false;
}
