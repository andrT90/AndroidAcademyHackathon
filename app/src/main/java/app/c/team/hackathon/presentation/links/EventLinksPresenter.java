package app.c.team.hackathon.presentation.links;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.presentation.event.EventView;
import app.c.team.hackathon.repository.EventRepository;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class EventLinksPresenter extends BasePresenter<EventLinksView> {

    private final Router router;
    @Inject
    public EventRepository eventRepository;

    public EventLinksPresenter(Router router) {
        super(null, router);
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }


    public void onBackPressed() {
        router.exit();
    }

}
