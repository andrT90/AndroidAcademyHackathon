package app.c.team.hackathon.presentation.info;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import app.c.team.hackathon.presentation.base.BaseView;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface EventInfoView extends BaseView {



}
