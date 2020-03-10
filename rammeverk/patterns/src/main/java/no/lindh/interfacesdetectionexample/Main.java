package no.lindh.interfacesdetectionexample;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Find classes that implement a specific interface
        Reflections reflections = new Reflections(
                "no.lindh.interfacesdetectionexample",
                new SubTypesScanner()
        );
        Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);
        Map<String, Command> cmds = new HashMap<>();

        for (Class<? extends Command> cmdClass : classes) {
            try {
                Command cmd = cmdClass.newInstance();
                String name = cmdClass.getSimpleName().toLowerCase();
                cmds.put(name, cmd);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (args.length == 0) {
            System.err.println("Usage: java Main <command>");
            return;
        }

        String cmd = args[0];

        if (!cmds.containsKey(cmd)) {
            System.err.println("Did not find command " + cmd);
            return;
        }

        Command cmdToInvoke = cmds.get(cmd);
        cmdToInvoke.invoke();
    }
}
