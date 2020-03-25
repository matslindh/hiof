package no.lindh.antipattern_dataonlyasstrings;

import java.util.Random;

public class Framework {
    protected int instanceId;

    public Framework() {
        instanceId = new Random().nextInt();
    }

    public String getInstanceId() {
        return Integer.toString(instanceId);
    }

    public String getInstance() {
        return "My instanceId is " + instanceId + ".";
    }
}

