package app.c.team.hackathon.presentation.base;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ErrorView extends MvpView {
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(@StringRes int id);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(String text);
}
