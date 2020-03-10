package no.lindh.observerexample;

import no.lindh.observerexample.observer.ObserverEvent;
import no.lindh.observerexample.observer.Subscriber;

public class EventOccurredCounter implements Subscriber {
    int occurred = 0;
    String name;

    EventOccurredCounter(String name) {
        this.name = name;
    }


    @Override
    public void update(ObserverEvent event) {
        occurred++;

        System.out.println("[" + this.name + "] Event " + event.eventType + " has now occured " + occurred + " times.");
    }
}
