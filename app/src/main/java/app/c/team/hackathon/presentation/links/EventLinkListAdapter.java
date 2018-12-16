package app.c.team.hackathon.presentation.links;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.List;

import app.c.team.hackathon.model.domain.Vacancy;

public class EventLinkListAdapter extends ListDelegationAdapter<List<Object>> {
    public EventLinkListAdapter(Callback callback) {
        delegatesManager.addDelegate(new EventLinkAdapterDelegate(callback));
    }

    public void setData(List<Object> data) {
        setItems(data);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onEventClick(Vacancy vacancy);
    }
}