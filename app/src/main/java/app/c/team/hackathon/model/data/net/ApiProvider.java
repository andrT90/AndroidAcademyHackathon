package app.c.team.hackathon.model.data.net;

import javax.inject.Inject;

public class ApiProvider {
    private final AndroidAcademyApi api;

    @Inject
    public ApiProvider(AndroidAcademyApi api) {
        this.api = api;
    }
}
