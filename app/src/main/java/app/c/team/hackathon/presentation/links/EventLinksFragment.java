package app.c.team.hackathon.presentation.links;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import app.c.team.hackathon.presentation.info.EventInfoPresenter;
import app.c.team.hackathon.presentation.info.EventInfoView;

public class EventLinksFragment extends BaseFragment implements BackButtonListener, EventLinksView {

    @InjectPresenter
    EventLinksPresenter presenter;

    @ProvidePresenter
    EventLinksPresenter provideTutorialPresenter() {
        return new EventLinksPresenter(((BottomNavView) getActivity()).getRouter());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event_links;
    }


    public static EventLinksFragment newInstance() {

        Bundle args = new Bundle();

        EventLinksFragment fragment = new EventLinksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }


    private void initViews() {

    }

    @Override
    public boolean onBackPressed() {
        presenter.backClicked();
        return true;
    }


}
