package app.c.team.hackathon.presentation.info;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.presentation.event.EventView;
import app.c.team.hackathon.repository.EventRepository;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class EventInfoPresenter extends BasePresenter<EventInfoView> {

    private final Router router;
    @Inject
    public EventRepository eventRepository;

    public EventInfoPresenter(Router router) {
        super(null, router);
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadData();
    }

    private void loadData() {
//        addToComposite(eventRepository.getEvent());
    }

    public void onBackPressed() {
        router.exit();
    }

}
