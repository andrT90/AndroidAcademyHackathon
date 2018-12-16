package app.c.team.hackathon.repository;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;
import app.c.team.hackathon.model.domain.Event;
import io.reactivex.Single;

public class EventRepository {

    private final ApiProvider apiProvider;

    @Inject
    public EventRepository(ApiProvider apiProvider) {
        this.apiProvider = apiProvider;
    }

    public Single<List<Event>> getEventList() {
        return apiProvider.getEventList();
    }
}
