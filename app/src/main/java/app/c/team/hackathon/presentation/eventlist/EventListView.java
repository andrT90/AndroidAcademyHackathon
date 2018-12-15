package app.c.team.hackathon.presentation.eventlist;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.c.team.hackathon.presentation.base.BaseView;

public interface EventListView extends BaseView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showData(List<Object> data);
}
