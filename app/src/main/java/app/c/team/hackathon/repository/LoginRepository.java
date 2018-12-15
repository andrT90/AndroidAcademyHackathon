package app.c.team.hackathon.repository;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;
import app.c.team.hackathon.model.data.net.TokenResult;
import io.reactivex.Single;

public class LoginRepository {

    private final ApiProvider provider;

    @Inject
    LoginRepository(ApiProvider provider) {
        this.provider = provider;
    }

    public Single<TokenResult> login(String email){
        return provider.login(email);
    }

}
