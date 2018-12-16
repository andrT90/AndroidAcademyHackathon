package app.c.team.hackathon.presentation.mentors;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.repository.MentorRepository;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class MentorListPresenter extends BasePresenter<MentorListView> {

    private static final String TAG = MentorListPresenter.class.getName();
    private List<MentorItem> mentorItemList;

    private final Router router;

    @Inject
    MentorRepository mentorRepository;

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
        addToComposite(mentorRepository.loadData()
                .subscribe(
                        mentorItems -> {
                            mentorItemList = mentorItems;
                            getViewState().showMentors(mentorItemList);
                        },

                        throwable -> {
                            if (throwable instanceof Exception)
                                Log.e(TAG, "loadData: " + throwable.getMessage());
                        }));
    }
}
