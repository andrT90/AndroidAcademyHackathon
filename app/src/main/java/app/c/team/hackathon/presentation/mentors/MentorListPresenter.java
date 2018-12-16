package app.c.team.hackathon.presentation.mentors;

import com.arellomobile.mvp.InjectViewState;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class MentorListPresenter extends BasePresenter<MentorListView> {


    private final Router router;

    MentorListPresenter(Router router) {
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

    }
}
