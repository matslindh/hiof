package no.lindh.annotationsexample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

public class Main {
    public static void main(String[] args) {
        // Find methods annotated with a command line argument
        Reflections reflections = new Reflections("no.lindh.annotationsexample", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(CommandAnnotation.class);
        Map<String, Method> cmds = new HashMap<>();

        for (Method method : methods) {
            CommandAnnotation annotation = method.getAnnotation(CommandAnnotation.class);
            cmds.put(annotation.value(), method);
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

        Method callMe = cmds.get(cmd);

        try {
            callMe.invoke(null);
        } catch (IllegalAccessException e) {
            System.out.println("cmd could not be invoked - IAE: " + cmd);
        } catch (InvocationTargetException e) {
            System.out.println("cmd could not be invoked as a target - ITE: " + cmd);
            e.printStackTrace();
        }
    }
}
