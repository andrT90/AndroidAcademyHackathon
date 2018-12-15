package app.c.team.hackathon;

import android.support.v4.app.Fragment;

import app.c.team.hackathon.presentation.eventlist.EventListFragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static class EventListScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return EventListFragment.newInstance();
        }
    }
}
