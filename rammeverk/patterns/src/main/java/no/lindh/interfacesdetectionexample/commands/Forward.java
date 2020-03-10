package no.lindh.interfacesdetectionexample.commands;
import no.lindh.interfacesdetectionexample.Command;

public class Forward implements Command {
    public void invoke() {
        System.out.println(Forward.class.getName() + " got called");
    }
}
