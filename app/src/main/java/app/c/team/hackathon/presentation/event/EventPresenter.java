package app.c.team.hackathon.presentation.event;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.repository.EventRepository;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class EventPresenter extends BasePresenter<EventView> {

    private final Router router;
    @Inject
    public EventRepository eventRepository;
    private Event event;

    public EventPresenter(Router router, Event event) {
        super(null, router);
        this.event = event;
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }


    public void onBackPressed() {
        backClicked();
    }


}
