package no.lindh.observerexample.observer;

import java.util.Collections;
import java.util.Map;

public class ObserverEvent {
    public final String eventType;
    private final Map<String, String> data;

    ObserverEvent(String eventType, Map<String, String> data) {
        this.eventType = eventType;
        this.data = data;
    }

    public Map<String, String> getData() {
        return Collections.unmodifiableMap(this.data);
    }
}
