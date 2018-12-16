package app.c.team.hackathon.repository;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;
import app.c.team.hackathon.model.data.net.TokenResult;
import io.reactivex.Single;

public class MentorRepository {

        private final ApiProvider provider;

        @Inject
        MentorRepository(ApiProvider provider) {
            this.provider = provider;
        }

        public Single<TokenResult> loadData(){
            return provider.loadMentorData();
        }

}
