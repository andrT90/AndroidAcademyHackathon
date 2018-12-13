package app.c.team.hackathon.model.navigation;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class HackathonNavigator extends SupportAppNavigator {
    public HackathonNavigator(FragmentActivity activity, FragmentManager fragmentManager, int containerId) {
        super(activity, fragmentManager, containerId);
    }
}
