package app.c.team.hackathon.presentation.vacancies;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import app.c.team.hackathon.presentation.base.BaseView;
import app.c.team.hackathon.presentation.base.LoadingView;

public interface VacancyListView extends MvpView, LoadingView, BaseView {
    void showMentors(List<VacancyItem> vacancyItemList);
}
