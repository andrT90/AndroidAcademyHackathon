package app.c.team.hackathon.presentation.bottom;

import android.support.annotation.Nullable;

import app.c.team.hackathon.presentation.base.BasePresenter;
import ru.terrakok.cicerone.Router;

public class BottomNavPresenter extends BasePresenter<BottomNavView> {
    public BottomNavPresenter(@Nullable Router mainRouter, @Nullable Router localRouter) {
        super(mainRouter, localRouter);
    }
}
