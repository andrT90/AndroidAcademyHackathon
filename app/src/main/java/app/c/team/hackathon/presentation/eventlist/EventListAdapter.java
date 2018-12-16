package app.c.team.hackathon.presentation.eventlist;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.List;

import app.c.team.hackathon.model.domain.Event;

public class EventListAdapter extends ListDelegationAdapter<List<Object>> {
    public EventListAdapter(Callback callback) {
        delegatesManager.addDelegate(new EventListAdapterDelegate(callback));
    }


    public interface Callback {
        void onEventClick(Event event);

        void onLocationClick(Event event);
    }
}
