package app.c.team.hackathon.repository;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;

public class EventRepository {

    private final ApiProvider apiProvider;

    @Inject
    public EventRepository(ApiProvider apiProvider) {
        this.apiProvider = apiProvider;
    }
}
