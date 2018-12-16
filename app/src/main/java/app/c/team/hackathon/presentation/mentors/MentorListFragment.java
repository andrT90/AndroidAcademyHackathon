package app.c.team.hackathon.presentation.mentors;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import butterknife.BindView;
import ru.terrakok.cicerone.Router;

public class MentorListFragment extends BaseFragment implements BackButtonListener, MentorListView {

    @BindView(R.id.mentors_recycler)
    RecyclerView recyclerView;

    @InjectPresenter
    MentorListPresenter presenter;

    @Inject
    Router router;
    private MentorListAdapter adapter;

    @ProvidePresenter
    MentorListPresenter provideTutorialPresenter() {
        return new MentorListPresenter(router);
    }


    public static MentorListFragment newInstance() {

        Bundle args = new Bundle();

        MentorListFragment fragment = new MentorListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter = new MentorListAdapter(user -> {
        });
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }


    @Override
    public int getLayoutResId() {
        return R.layout.mentors;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
    }


    @Override
    public boolean onBackPressed() {
        presenter.backClicked();
        return true;
    }

    @Override
    public void showMentors(List<MentorItem> mentorItemList) {
        List<Object> objects = new ArrayList<>();
        for (MentorItem item : mentorItemList) {
            Object object = (Object) item;
            objects.add(object);
        }
        adapter.setData(objects);
    }
}
