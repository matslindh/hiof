package no.lindh.annotationsexample2;

import no.lindh.annotationsexample2.annotations.Cacheable;
import no.lindh.annotationsexample2.annotations.Command;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Framework {
    Map<String, Method> availableCommands = new HashMap<>();
    Map<Method, Integer> resultCache = new HashMap<>();

    public Framework() {
        Reflections reflections = new Reflections(
                "no.lindh.annotationsexample2",
                new MethodAnnotationsScanner()
        );
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Command.class);

        for (Method method : methods) {
            Command annotation = method.getAnnotation(Command.class);
            availableCommands.put(annotation.value(), method);
        }
    }

    public int execute(String cmd, int argument) {
        if (!availableCommands.containsKey(cmd)) {
            throw new UnknownCommandException();
        }

        Method callMe = availableCommands.get(cmd);

        try {
            Cacheable cacheable = callMe.getAnnotation(Cacheable.class);
            boolean isCacheable = cacheable != null;

            // We should consider the `argument` value part of the lookup - otherwise we'll just get
            // the same value returned even if we change the calling argument value.
            //
            // This is left as an exercise for the reader (simple / naive implementation: multiple levels of Maps)
            //
            // Additionally we have the `ttl` value on the cache decorator - this should be used to only keep the
            // value in the cache for a certain amount of time.
            //
            // Try to implement support for these features yourself.
            if (isCacheable) {
                if (resultCache.containsKey(callMe)) {
                    return resultCache.get(callMe);
                }

                System.out.println("Method is cachable");
            } else {
                System.out.println("Method is not cachable");
            }

            int result = (int) callMe.invoke(null, argument);

            if (isCacheable) {
                resultCache.put(callMe, result);
            }

            return result;
        } catch (IllegalAccessException e) {
            System.out.println("cmd could not be invoked - IAE: " + cmd);
        } catch (InvocationTargetException e) {
            System.out.println("cmd could not be invoked as a target - ITE: " + cmd);
            e.printStackTrace();
        }

        throw new CommandErrorException();
    }
}

class UnknownCommandException extends RuntimeException {}
class CommandErrorException extends RuntimeException {}
