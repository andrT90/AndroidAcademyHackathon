package app.c.team.hackathon.presentation.vacancies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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

public class VacancyListFragment extends BaseFragment implements BackButtonListener, VacancyListView {

    @BindView(R.id.mentors_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar_title)
    TextView title;

    @InjectPresenter
    VacancyListPresenter presenter;

    @Inject
    Router router;
    private VacancyListAdapter adapter;

    @ProvidePresenter
    VacancyListPresenter provideTutorialPresenter() {
        return new VacancyListPresenter(router);
    }


    public static VacancyListFragment newInstance() {

        Bundle args = new Bundle();

        VacancyListFragment fragment = new VacancyListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter = new VacancyListAdapter(vacancy -> {
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        title.setText(R.string.vacancies_title);
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
    public void showMentors(List<VacancyItem> vacancyItemList) {
        List<Object> objects = new ArrayList<>(vacancyItemList);
        adapter.setData(objects);
    }
}
