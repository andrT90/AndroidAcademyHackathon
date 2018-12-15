package app.c.team.hackathon.presentation.eventlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collection;
import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BaseFragment;
import butterknife.BindView;

public class EventListFragment extends BaseFragment implements EventListView {

    public static EventListFragment newInstance() {

        Bundle args = new Bundle();

        EventListFragment fragment = new EventListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.events)
    protected RecyclerView events;

    private EventListAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.event_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (adapter == null) adapter = new EventListAdapter(new EventListAdapter.Callback() {
            @Override
            public void onEventClick(Event event) {

            }

            @Override
            public void onLocationClick(Event event) {

            }
        });

        events.setLayoutManager(new LinearLayoutManager(getContext()));
        events.setAdapter(adapter);
    }

    @Override
    public void showData(List<Object> data) {
        adapter.setItems(data);
    }
}
