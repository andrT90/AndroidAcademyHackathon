package app.c.team.hackathon.presentation.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import app.c.team.hackathon.presentation.event.EventPresenter;
import app.c.team.hackathon.presentation.event.EventView;
import butterknife.BindView;

public class EventInfoFragment extends BaseFragment implements BackButtonListener, EventInfoView {

    @InjectPresenter
    EventInfoPresenter presenter;

    @ProvidePresenter
    EventInfoPresenter provideTutorialPresenter() {
        return new EventInfoPresenter(((BottomNavView) getActivity()).getRouter());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event_info;
    }


    public static EventInfoFragment newInstance() {

        Bundle args = new Bundle();

        EventInfoFragment fragment = new EventInfoFragment();
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
