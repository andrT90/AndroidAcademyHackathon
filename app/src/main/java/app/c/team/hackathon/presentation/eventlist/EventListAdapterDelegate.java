package app.c.team.hackathon.presentation.eventlist;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.util.ViewUtil;

public class EventListAdapterDelegate extends AbsListItemAdapterDelegate<EventItem, Object, EventViewHolder> {
    private final EventListAdapter.Callback callback;

    public EventListAdapterDelegate(EventListAdapter.Callback callback) {
        this.callback = callback;
    }

    @Override
    protected boolean isForViewType(@NonNull Object item, @NonNull List<Object> items, int position) {
        return item instanceof EventItem;
    }

    @NonNull
    @Override
    protected EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new EventViewHolder(ViewUtil.inflate(parent, R.layout.event_list_item));
    }

    @Override
    protected void onBindViewHolder(@NonNull EventItem item, @NonNull EventViewHolder holder, @NonNull List<Object> payloads) {
        holder.bind(item, callback);
    }
}
