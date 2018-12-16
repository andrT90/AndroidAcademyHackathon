package app.c.team.hackathon.presentation.bottom;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.R;
import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.navigation.HackathonNavigator;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.TabContainerFragment;
import app.c.team.hackathon.view.MessageDelegate;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class BottomNavActivity extends MvpAppCompatActivity implements BottomNavView {

    private HackathonNavigator navigator;

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Router router;

    @InjectPresenter
    BottomNavPresenter presenter;

    private MessageDelegate messageDelegate;

    @ProvidePresenter
    BottomNavPresenter providePresenter() {
        return new BottomNavPresenter(router, null);
    }

    @BindView(R.id.bottom_nav_view)
    protected BottomNavigationView bottomNavView;

    private Fragment eventsTab = TabContainerFragment.newInstance(TabContainerFragment.EVENTS);
    private Fragment vacanciesTab = TabContainerFragment.newInstance(TabContainerFragment.VACANCIES);
    private Fragment mentorsTab = TabContainerFragment.newInstance(TabContainerFragment.MENTORS);
    private Fragment profileTab = TabContainerFragment.newInstance(TabContainerFragment.PROFILE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ComponentsHolder.getInstance().appComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom);

        ButterKnife.bind(this);

        messageDelegate = new MessageDelegate(this);

        if (navigator == null)
            navigator = new HackathonNavigator(this, getSupportFragmentManager(), getContainerId());

        bottomNavView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.lectures:
                    selectTab(TabContainerFragment.EVENTS);
                    return true;
                case R.id.mentors:
                    selectTab(TabContainerFragment.MENTORS);
                    return true;
                case R.id.vacancies:
                    selectTab(TabContainerFragment.VACANCIES);
                    return true;
                case R.id.profile:
                    selectTab(TabContainerFragment.PROFILE);
                    return true;
            }
            return false;
        });

        if (savedInstanceState == null) selectTab(TabContainerFragment.EVENTS);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        messageDelegate = null;
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getCurrentFragment();
        if (fragment instanceof BackButtonListener) {
            ((BackButtonListener) fragment).onBackPressed();
        } else presenter.backClicked();
    }

    private void selectTab(String screen) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment currentFragment = null;
        List<Fragment> fragments = fm.getFragments();
        for (Fragment f : fragments) {
            if (f.isVisible()) {
                currentFragment = f;
                break;
            }
        }
        Fragment newFragment = fm.findFragmentByTag(screen);

        if (newFragment != null && currentFragment == newFragment) return;

        FragmentTransaction transaction = fm.beginTransaction();
        if (newFragment == null) {
            transaction.add(getContainerId(), getTabByScreenName(screen), screen);
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }

        if (newFragment != null) {
            transaction.show(newFragment);
        }
        transaction.commitNow();
    }

    public Fragment getTabByScreenName(String screen) {
        switch (screen) {
            case TabContainerFragment.EVENTS:
                return eventsTab;
            case TabContainerFragment.VACANCIES:
                return vacanciesTab;
            case TabContainerFragment.MENTORS:
                return mentorsTab;
            case TabContainerFragment.PROFILE:
                return profileTab;
        }
        return eventsTab;
    }

    @Nullable
    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(getContainerId());
    }

    @IdRes
    private int getContainerId() {
        return R.id.container;
    }

    @Override
    public void showError(int id) {
        messageDelegate.showError(id);
    }

    @Override
    public void showError(String text) {
        messageDelegate.showError(text);
    }

    @Override
    public void showLoading(boolean show) {
        //empty
    }

    @Override
    public void showMessage(int id) {
        messageDelegate.showMessage(id);
    }

    @Override
    public void showMessage(String text) {
        messageDelegate.showMessage(text);
    }

    @Override
    public Router getRouter() {
        return router;
    }
}
