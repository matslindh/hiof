package no.lindh.observerexample.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {
    Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void notify(String eventType, Map<String, String> data) {
        if (!subscribers.containsKey(eventType)) {
            return;
        }

        ObserverEvent oe = new ObserverEvent(eventType, data);

        for (Subscriber subscriber : subscribers.get(eventType)) {
            subscriber.update(oe);
        }
    }

    public void subscribe(String event, Subscriber subscriber) {
        if (!subscribers.containsKey(event)) {
            subscribers.put(event, new ArrayList<>());
        }

        subscribers.get(event).add(subscriber);
    }
}
