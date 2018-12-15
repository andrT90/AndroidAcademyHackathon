package app.c.team.hackathon.presentation.notes;

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

public class EventNotesFragment extends BaseFragment implements BackButtonListener, EventNotesView {

    @InjectPresenter
    EventNotesPresenter presenter;

    @ProvidePresenter
    EventNotesPresenter provideTutorialPresenter() {
        return new EventNotesPresenter(((BottomNavView) getActivity()).getRouter());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event_notes;
    }


    public static EventNotesFragment newInstance() {

        Bundle args = new Bundle();

        EventNotesFragment fragment = new EventNotesFragment();
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
    public void onBackPressed() {
        presenter.onBackPressed();
    }


}
