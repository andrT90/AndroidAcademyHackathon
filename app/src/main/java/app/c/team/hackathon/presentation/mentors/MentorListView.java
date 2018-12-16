package app.c.team.hackathon.presentation.mentors;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import app.c.team.hackathon.presentation.base.BaseView;
import app.c.team.hackathon.presentation.base.LoadingView;

public interface MentorListView extends MvpView, LoadingView, BaseView {
    void showMentors(List<MentorItem> mentorItemList);
}
