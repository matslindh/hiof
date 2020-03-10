package no.lindh.annotationsexample;

public class Controller {
    @CommandAnnotation("forward")
    static public void forward() {
        System.out.println("Forward called");
    }

    @CommandAnnotation("backward")
    static public void reverse() {
        System.out.println("Reverse called");
    }
}
