package app.c.team.hackathon.presentation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import app.c.team.hackathon.R;
import app.c.team.hackathon.Screens;
import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.data.LocalCiceroneHolder;
import app.c.team.hackathon.model.navigation.HackathonNavigator;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;

public class TabContainerFragment extends Fragment implements BackButtonListener {

    public static final String EVENTS = "events";
    public static final String VACANCIES = "vacancies";
    public static final String MENTORS = "mentors";
    public static final String PROFILE = "profile";

    private static final String KEY_NAME = "key name";


    public static TabContainerFragment newInstance(String tabName) {

        Bundle args = new Bundle();
        args.putString(KEY_NAME, tabName);
        TabContainerFragment fragment = new TabContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private HackathonNavigator navigator;

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Override
    public void onAttach(@Nullable Context context) {
        ComponentsHolder.getInstance().appComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (navigator == null)
            navigator = new HackathonNavigator(getActivity(), getChildFragmentManager(), getTabContainerId());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getCurrentFragment() == null) {
            if (getLocalCicerone() == null) return;
            Router router = getLocalCicerone().getRouter();
            if (router == null) return;
            switch (getContainerName()) {
                case EVENTS:
                    router.replaceScreen(new Screens.EventListScreen());
                    break;
                case VACANCIES:
                    break;
                case MENTORS:
                    router.replaceScreen(new Screens.MentorListScreen());
                    break;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getLocalCicerone() != null) {
            getLocalCicerone().getNavigatorHolder().setNavigator(navigator);
        }
    }


    @Override
    public void onPause() {
        if (getLocalCicerone() != null) {
            getLocalCicerone().getNavigatorHolder().setNavigator(navigator);
        }
        super.onPause();
    }

    @Override
    public boolean onBackPressed() {
        Fragment fragment = getCurrentFragment();

        if (fragment instanceof BackButtonListener && ((BackButtonListener) fragment).onBackPressed())
            return true;
        else {
            ((BottomNavView) getActivity()).getRouter().exit();
            return true;
        }

    }

    public Router getRouter() {
        return getLocalCicerone() == null ? null : getLocalCicerone().getRouter();
    }

    @Nullable
    public Cicerone<Router> getLocalCicerone() {
        return localCiceroneHolder.getCicerone(getContainerName());
    }

    @Nullable
    private Fragment getCurrentFragment() {
        return getChildFragmentManager().findFragmentById(getTabContainerId());
    }

    @IdRes
    private int getTabContainerId() {
        return R.id.ft_container;
    }

    private String getContainerName() {
        return getArguments() != null ? getArguments().getString(KEY_NAME) : "";
    }
}
