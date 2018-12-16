package app.c.team.hackathon.presentation.info;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.Screens;
import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.presentation.event.EventView;
import app.c.team.hackathon.repository.EventRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class EventInfoPresenter extends BasePresenter<EventInfoView> {

    private final Router router;
    @Inject
    public EventRepository eventRepository;
    private Event event;

    public EventInfoPresenter(Router router, Event event) {
        super(null, router);
        this.event = event;
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showEvent(event);
        loadData();
    }

    private void loadData() {
        addToComposite(eventRepository.getEvent(event.getId())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showLoading(true))
                .doAfterTerminate(() -> getViewState().showLoading(false))
                .subscribe(event -> {
                    this.event = event;
                    getViewState().showEvent(event);
                }, throwable -> getViewState().showError("Сорян, братан")));
    }

    public void onBackPressed() {
        router.exit();
    }

}
