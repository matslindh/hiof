package no.lindh.callbackexample;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Command> cmds = new HashMap<>();

        cmds.put("forward", () -> System.out.println("Going forward"));
        cmds.put("backward", () -> System.out.println("Going backward"));

        if (args.length == 0) {
            System.err.println("Usage: java Main <command>");
            return;
        }

        String cmd = args[0];

        if (!cmds.containsKey(cmd)) {
            System.err.println("Did not find command " + cmd);
            return;
        }

        cmds.get(cmd).invoke();
    }
}
