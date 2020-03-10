package no.lindh.observerexample;

import no.lindh.observerexample.observer.ObserverEvent;
import no.lindh.observerexample.observer.Publisher;
import no.lindh.observerexample.observer.Subscriber;

public class Main {
    public static void main(String[] args) {
        Publisher hub = new Publisher();

        hub.subscribe("created", new EventOccurredCounter("dog"));
        hub.subscribe("modified", new EventOccurredCounter("cat"));
        hub.subscribe("deleted", new EventOccurredCounter("horse"));

        hub.notify("created", null);
        hub.notify("created", null);
        hub.subscribe("created", new EventOccurredCounter("better-dog"));

        hub.notify("created", null);
        hub.notify("modified", null);
        hub.notify("deleted", null);

        // we can also create an anonymous listener based on the interface if we don't need a complete class with state
        hub.subscribe("created", new Subscriber() {
            public void update(ObserverEvent oe) {
                System.out.println("!! Anonymous subscriber got call for " +  oe.eventType);
            }
        });

        // the lambda syntax makes this more compact and readable (if you're familiar with the syntax)
        hub.subscribe("created", (oe) -> System.out.println("!! Lambda subscriber got call for " + oe.eventType));
        hub.notify("created", null);
        hub.notify("created", null);
    }
}
