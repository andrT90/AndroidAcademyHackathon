package app.c.team.hackathon.presentation.vacancies;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.repository.VacancyRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class VacancyListPresenter extends BasePresenter<VacancyListView> {

    private static final String TAG = VacancyListPresenter.class.getName();
    private List<VacancyItem> vacancyItemList;

    private final Router router;

    @Inject
    VacancyRepository vacancyRepository;

    VacancyListPresenter(Router router) {
        super(router, null);
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }


    public void onBackPressed() {
        router.exit();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadData();
    }

    private void loadData() {
        addToComposite(vacancyRepository.loadData()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> getViewState().showLoading(true))
                .doAfterTerminate(() -> getViewState().showLoading(false))
                .subscribe(
                        vacancyItems -> {
                            vacancyItemList = vacancyItems;
                            getViewState().showMentors(vacancyItemList);
                        },

                        throwable -> {
                            if (throwable instanceof Exception)
                                Log.e(TAG, "loadData: " + throwable.getMessage());
                        }));
    }
}
