package app.c.team.hackathon.repository;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;
import app.c.team.hackathon.presentation.mentors.MentorItem;
import io.reactivex.Single;

public class MentorRepository {

    private final ApiProvider provider;

    @Inject
    MentorRepository(ApiProvider provider) {
        this.provider = provider;
    }

    public Single<List<MentorItem>> loadData() {
        return provider.loadMentorData();
    }

}
