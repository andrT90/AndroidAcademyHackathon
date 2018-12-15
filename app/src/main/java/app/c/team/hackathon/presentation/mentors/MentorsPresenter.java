package app.c.team.hackathon.presentation.mentors;

import com.arellomobile.mvp.InjectViewState;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class MentorsPresenter extends BasePresenter<MentorsView> {

    private final Router router;

    MentorsPresenter(Router router) {
        super(router, null);
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }


    public void onBackPressed() {
        router.exit();
    }


}
