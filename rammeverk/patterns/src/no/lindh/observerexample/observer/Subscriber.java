package no.lindh.observerexample.observer;

public interface Subscriber {
    void update(ObserverEvent event);
}
