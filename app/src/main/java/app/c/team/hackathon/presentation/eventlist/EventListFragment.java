package app.c.team.hackathon.presentation.eventlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.R;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.base.TabContainerFragment;
import app.c.team.hackathon.util.ViewUtil;
import butterknife.BindView;
import ru.terrakok.cicerone.Router;

public class EventListFragment extends BaseFragment implements EventListView, BackButtonListener {

    public static EventListFragment newInstance() {

        Bundle args = new Bundle();

        EventListFragment fragment = new EventListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    Router router;


    @InjectPresenter
    EventListPresenter presenter;

    @ProvidePresenter
    EventListPresenter providePresenter() {
        return new EventListPresenter(router, ((TabContainerFragment) getParentFragment()).getRouter());
    }

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

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
                presenter.eventClicked(event);
            }

            @Override
            public void onLocationClick(Event event) {
                if (getContext() == null) return;
                ViewUtil.geoIntent(getContext(), event.getLocation().getLatitude(), event.getLocation().getLongitude());
            }
        });

        events.setLayoutManager(new LinearLayoutManager(getContext()));
        events.setAdapter(adapter);

        toolbarTitle.setText(R.string.event_list_title);
    }


    @Override
    public void showData(List<Object> data) {
        adapter.setData(data);
    }

    @Override
    public boolean onBackPressed() {
        presenter.backClicked();
        return true;
    }
}
