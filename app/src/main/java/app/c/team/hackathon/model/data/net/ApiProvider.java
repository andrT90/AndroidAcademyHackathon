package app.c.team.hackathon.model.data.net;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.model.domain.Event;
import io.reactivex.Single;

public class ApiProvider {
    private final AndroidAcademyApi api;

    @Inject
    public ApiProvider(AndroidAcademyApi api) {
        this.api = api;
    }

    public Single<TokenResult> login(String email) {
        return api
                .login(email)
                .map(BaseResponse::getData);
    }

    public Single<List<Event>> getEventList() {
        return api
                .getEventList()
                .map(BaseResponse::getData);
    }

    public Single<Event> getEvent(int id) {
        return api
                .getEvent(id)
                .map(BaseResponse::getData);

    }
}
