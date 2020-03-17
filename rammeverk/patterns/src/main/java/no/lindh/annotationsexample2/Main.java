package no.lindh.annotationsexample2;

public class Main {
    public static void main(String[] args) {
        Framework framework = new Framework();
        System.out.println("Result Squared: " + framework.execute("squared", 2));
        System.out.println("Result Squared: " + framework.execute("squared", 2));
        System.out.println("Result Squared: " + framework.execute("squared", 2));
        System.out.println("Result Added: " + framework.execute("added", 2));
        System.out.println("Result Added: " + framework.execute("added", 2));
        System.out.println("Result Added: " + framework.execute("added", 2));

    }
}
