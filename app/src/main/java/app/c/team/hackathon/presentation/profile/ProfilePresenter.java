package app.c.team.hackathon.presentation.profile;

import android.support.annotation.Nullable;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import ru.terrakok.cicerone.Router;

public class ProfilePresenter extends BasePresenter<ProfileView> {
    public ProfilePresenter(@Nullable Router mainRouter, @Nullable Router localRouter) {
        super(mainRouter, localRouter);
        ComponentsHolder.getInstance().appComponent().inject(this);
    }
}
