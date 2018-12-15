package app.c.team.hackathon.presentation.login;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import app.c.team.hackathon.presentation.base.BaseView;
import app.c.team.hackathon.presentation.base.LoadingView;


@StateStrategyType(AddToEndSingleStrategy.class)
public interface LoginView extends MvpView, LoadingView, BaseView {

    void validationFailed();
}
