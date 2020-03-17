package no.lindh.annotationsexample2;

import no.lindh.annotationsexample2.annotations.Cacheable;
import no.lindh.annotationsexample2.annotations.Command;

public class Calculator {
    @Command("squared")
    @Cacheable
    static public int squared(int n) {
        System.out.println("Squared called");
        return n * n;
    }

    @Command("added")
    static public int added(int n) {
        System.out.println("Added called");
        return n + n;
    }
}
