package no.lindh.antipattern_singleton;

import java.util.Random;

public class ApplicationSingleton {
    static private Application app;

    private ApplicationSingleton() {}

    static public Application getInstance() {
        if (ApplicationSingleton.app == null) {
            ApplicationSingleton.app = new Application();
        }

        return ApplicationSingleton.app;
    }
}

class Application {
    protected int instanceId;

    public Application() {
        instanceId = new Random().nextInt();
    }

    public int getInstanceId() {
        return instanceId;
    }
}

