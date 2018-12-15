package app.c.team.hackathon.presentation.eventlist;

import android.support.annotation.NonNull;
import android.view.View;

import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BaseViewHolder;

public class EventViewHolder extends BaseViewHolder {
    private Event item;
    private EventListAdapter.Callback callback;


    public void bind(Event event, EventListAdapter.Callback callback) {
        this.item = event;
        this.callback = callback;
    }

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
