package app.c.team.hackathon.presentation.bottom;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import butterknife.BindView;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;

public class BottomNavActivity extends MvpAppCompatActivity implements BottomNavView {

    @Inject
    Cicerone<Router> ciceroneHolder;

    @InjectPresenter
    BottomNavPresenter presenter;

    @ProvidePresenter
    BottomNavPresenter providePresenter() {
        return new BottomNavPresenter(ciceroneHolder.getRouter(), null);
    }

    @BindView(R.id.bottom_nav_view)
    protected BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom);

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.lectures:
                        return true;
                    case R.id.mentors:
                        return true;
                    case R.id.vacancies:
                        return true;
                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getCurrentFragment();
        if (fragment instanceof BackButtonListener) {
            ((BackButtonListener) fragment).onBackPressed();
        } else presenter.backClicked();
    }

    public void selectTab(Screen screen) {

    }

    @Nullable
    private Cicerone<Router> getLocalCicerone() {
        return ciceroneHolder;
    }

    @Nullable
    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(getTabContainerId());
    }

    @IdRes
    private int getTabContainerId() {
        return R.id.container;
    }
}
