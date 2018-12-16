package app.c.team.hackathon.presentation.eventlist;

import app.c.team.hackathon.model.domain.Event;

public class EventItem {
    private final Event item;
    private final boolean isLast;
    private final boolean isFirst;


    public EventItem(Event item) {
        this(item, false, false);
    }

    public EventItem(Event item, boolean isLast, boolean isFirst) {
        this.item = item;
        this.isLast = isLast;
        this.isFirst = isFirst;
    }

}
