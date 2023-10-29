import java.util.ArrayList;
import java.util.List;

interface EventSubscriber {
    void update(String message);
}

class ConferenceAttendee implements EventSubscriber {
    private String name;

    public ConferenceAttendee(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class ConferenceEventManager {
    private List<EventSubscriber> subscribers = new ArrayList<>();

    public void subscribe(EventSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(EventSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        for (EventSubscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

class EventFactory {
    public Event createEvent(String eventName) {
        return new Event(eventName);
    }
}

class Event {
    private String name;

    public Event(String name) {
        this.name = name;
    }

    public void announceEvent(ConferenceEventManager manager, String message) {
        System.out.println("Announcing event '" + name + "'.");
        manager.notifySubscribers(message);
    }
}

public class Ass4 {
    public static void main(String[] args) {

        ConferenceEventManager conferenceManager = new ConferenceEventManager();

        EventSubscriber attendee1 = new ConferenceAttendee("Alice");
        EventSubscriber attendee2 = new ConferenceAttendee("Bob");

        conferenceManager.subscribe(attendee1);
        conferenceManager.subscribe(attendee2);

        EventFactory eventFactory = new EventFactory();
        Event openingKeynote = eventFactory.createEvent("Opening Keynote");

        openingKeynote.announceEvent(conferenceManager, "Join us for the opening keynote at 9:00 AM!");

        conferenceManager.unsubscribe(attendee2);

        Event workshopEvent = eventFactory.createEvent("Workshop Session");
        workshopEvent.announceEvent(conferenceManager, "Our workshop on Java design patterns starts at 2:00 PM!");
    }
}
