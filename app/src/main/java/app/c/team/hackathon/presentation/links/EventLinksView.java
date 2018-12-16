package app.c.team.hackathon.presentation.links;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.c.team.hackathon.presentation.base.BaseView;
import app.c.team.hackathon.presentation.vacancies.VacancyItem;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface EventLinksView extends BaseView {
    void showLinks(List<EventLinkItem> eventLinkItems);
}
