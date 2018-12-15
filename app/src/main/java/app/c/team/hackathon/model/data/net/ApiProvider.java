package app.c.team.hackathon.model.data.net;

import javax.inject.Inject;

import io.reactivex.Single;

public class ApiProvider {
    private final AndroidAcademyApi api;

    @Inject
    public ApiProvider(AndroidAcademyApi api) {
        this.api = api;
    }

    public Single<TokenResult> login(String email){
        return api.login(email).map(BaseResponse::getData);
    }
}
