package app.c.team.hackathon.presentation.links;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import app.c.team.hackathon.presentation.info.EventInfoPresenter;
import app.c.team.hackathon.presentation.info.EventInfoView;
import app.c.team.hackathon.presentation.vacancies.VacancyItem;
import app.c.team.hackathon.presentation.vacancies.VacancyListAdapter;
import butterknife.BindView;

public class EventLinksFragment extends BaseFragment implements BackButtonListener, EventLinksView {

    @InjectPresenter
    EventLinksPresenter presenter;
    private EventLinkListAdapter adapter;
    @BindView(R.id.event_links_recycler)
    RecyclerView recyclerView;

    @ProvidePresenter
    EventLinksPresenter provideTutorialPresenter() {
        return new EventLinksPresenter(((BottomNavView) getActivity()).getRouter(), getArguments().getInt("event_id"));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event_links;
    }


    public static EventLinksFragment newInstance(int id) {

        Bundle args = new Bundle();

        EventLinksFragment fragment = new EventLinksFragment();
        args.putInt("event_id", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }


    private void initViews() {
        adapter = new EventLinkListAdapter(vacancy -> {});
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onBackPressed() {
        presenter.backClicked();
        return true;
    }

    @Override
    public void showLinks(List<EventLinkItem> eventLinkItems) {
        List<Object> objects = new ArrayList<>(eventLinkItems);
        adapter.setData(objects);
    }


}
