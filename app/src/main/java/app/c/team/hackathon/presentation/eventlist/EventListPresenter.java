package app.c.team.hackathon.presentation.eventlist;

import android.support.annotation.Nullable;

import app.c.team.hackathon.presentation.base.BasePresenter;
import ru.terrakok.cicerone.Router;

public class EventListPresenter extends BasePresenter<EventListView> {

    public EventListPresenter(@Nullable Router mainRouter, @Nullable Router localRouter) {
        super(mainRouter, localRouter);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }
}
