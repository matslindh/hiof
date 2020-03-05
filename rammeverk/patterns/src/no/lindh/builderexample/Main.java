package no.lindh.builderexample;

public class Main {
    public static void main(String[] args) {
        // naive way with parameter heavy constructor
        BadCar badCar = new BadCar(3, 4, 5, true, false);

        // simple builder pattern
        CarBuilder builder = new CarBuilder()
                .doors(2)
                .hasNoEngine()
                .seats(4);
        Car car = builder.car();

        System.out.println(car.hasEngine);
    }
}

