package app.c.team.hackathon.presentation.links;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.presentation.vacancies.VacancyListPresenter;
import app.c.team.hackathon.repository.ResourceLinkRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class EventLinksPresenter extends BasePresenter<EventLinksView> {

    private static final String TAG = VacancyListPresenter.class.getName();
    private final Router router;
    @Inject
    public ResourceLinkRepository resourceLinkRepository;
    private int id;

    public EventLinksPresenter(Router router, int id) {
        super(null, router);
        this.id = id;
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadData();
    }

    private void loadData() {
        addToComposite(resourceLinkRepository.loadData(id)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> getViewState().showLoading(true))
                .doAfterTerminate(() -> getViewState().showLoading(false))
                .subscribe(
                        eventLinkItems -> {
                            getViewState().showLinks(eventLinkItems);
                        },

                        throwable -> {
                            if (throwable instanceof Exception)
                                Log.e(TAG, "loadData: " + throwable.getMessage());
                        }));
    }


    public void onBackPressed() {
        router.exit();
    }

}
