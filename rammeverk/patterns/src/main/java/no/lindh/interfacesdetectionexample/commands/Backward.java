package no.lindh.interfacesdetectionexample.commands;

import no.lindh.interfacesdetectionexample.Command;

public class Backward implements Command {
    public void invoke() {
        System.out.println("I am backwards :( ): sdrawkcab ma I");
    }
}
