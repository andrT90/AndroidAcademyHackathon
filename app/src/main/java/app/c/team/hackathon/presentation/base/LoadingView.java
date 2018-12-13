package app.c.team.hackathon.presentation.base;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface LoadingView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showLoading(boolean show);
}
