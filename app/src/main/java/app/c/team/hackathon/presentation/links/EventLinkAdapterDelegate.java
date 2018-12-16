package app.c.team.hackathon.presentation.links;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.util.ViewUtil;

public class EventLinkAdapterDelegate extends AbsListItemAdapterDelegate<EventLinkItem, Object, EventLinkViewHolder> {

    private final EventLinkListAdapter.Callback callback;

    public EventLinkAdapterDelegate(EventLinkListAdapter.Callback callback) {
        this.callback = callback;
    }

    @Override
    public boolean isForViewType(Object item, @NonNull List<Object> items, int position) {
        return item instanceof EventLinkItem;
    }


    @NonNull
    @Override
    public EventLinkViewHolder onCreateViewHolder(ViewGroup parent) {
        return new EventLinkViewHolder(ViewUtil.inflate(parent, R.layout.event_link_list_item));
    }

    @Override
    protected void onBindViewHolder(@NonNull EventLinkItem item, @NonNull EventLinkViewHolder holder, @NonNull List<Object> payloads) {
        holder.bind(item, callback);
    }
}