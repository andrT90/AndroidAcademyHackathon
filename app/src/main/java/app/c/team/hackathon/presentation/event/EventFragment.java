package app.c.team.hackathon.presentation.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import app.c.team.hackathon.presentation.info.EventInfoFragment;
import app.c.team.hackathon.presentation.links.EventLinksFragment;
import app.c.team.hackathon.presentation.notes.EventNotesFragment;
import butterknife.BindView;

public class EventFragment extends BaseFragment implements BackButtonListener, EventView {

    @InjectPresenter
    EventPresenter presenter;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private EventPagerAdapter pagerAdapter;

    @ProvidePresenter
    EventPresenter provideTutorialPresenter() {
        return new EventPresenter(((BottomNavView) getActivity()).getRouter());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event;
    }


    public static Fragment getNewInstance() {
        return new EventFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        pagerAdapter = new EventPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }

    private class EventPagerAdapter extends FragmentPagerAdapter {

        public EventPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return EventInfoFragment.newInstance();
                case 1:
                    return EventLinksFragment.newInstance();
                case 2:
                    return EventNotesFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}
