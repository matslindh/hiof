package no.lindh.antipattern_globalstate;

public class Main {
    public static void main(String[] args) {
        System.out.println(Printer.state);
        Printer.state = "Offline";
        System.out.println(Printer.state);
        turnOffPrinter();
        System.out.println(Printer.state);
    }

    static void turnOffPrinter() {
        // Misspelled on purpose
        Printer.state = "PowerÕff";
    }
}
