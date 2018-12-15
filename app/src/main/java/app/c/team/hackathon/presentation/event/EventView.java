package app.c.team.hackathon.presentation.event;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.c.team.hackathon.presentation.base.BaseView;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface EventView extends BaseView {



}
