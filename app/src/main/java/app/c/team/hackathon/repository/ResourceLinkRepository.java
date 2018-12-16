package app.c.team.hackathon.repository;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;
import app.c.team.hackathon.presentation.links.EventLinkItem;
import app.c.team.hackathon.presentation.vacancies.VacancyItem;
import io.reactivex.Single;

public class ResourceLinkRepository {

    private final ApiProvider provider;

    @Inject
    ResourceLinkRepository(ApiProvider provider) {
        this.provider = provider;
    }

    public Single<List<EventLinkItem>> loadData(int eventId) {
        return provider.getEventLinkList(eventId);
    }

}
