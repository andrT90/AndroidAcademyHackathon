package app.c.team.hackathon.repository;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.AndroidAcademyApi;
import app.c.team.hackathon.model.data.net.ApiProvider;

public class LoginRepository {

    private final ApiProvider provider;

    @Inject
    LoginRepository(ApiProvider provider) {
        this.provider = provider;
    }

}
