package app.c.team.hackathon.presentation.eventlist;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.Screens;
import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.data.AppSchedulers;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.repository.EventRepository;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class EventListPresenter extends BasePresenter<EventListView> {

    @Inject
    EventRepository eventRepository;

    @Inject
    AppSchedulers schedulers;

    public EventListPresenter(@Nullable Router mainRouter, @Nullable Router localRouter) {
        super(mainRouter, localRouter);
        ComponentsHolder.getInstance().appComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        addToComposite(
                eventRepository
                        .getEventList()
                        .map(list -> {
                            int count = list.size();
                            List<Object> objects = new ArrayList<>(count);
                            for (int i = 0; i < list.size(); i++) {
                                Event event = list.get(i);
                                objects.add(new EventItem(event, i == count - 1, i == 0));
                            }
                            return objects;
                        })
                        .observeOn(schedulers.main())
                        .subscribe(
                                list -> getViewState().showData(list),
                                throwable -> getViewState().showError(throwable.getMessage())
                        )
        );
    }

    public void eventClicked(Event event) {
        if (localRouter != null) localRouter.navigateTo(new Screens.EventScreen(event));
    }

    public void locationClicked() {

    }
}
