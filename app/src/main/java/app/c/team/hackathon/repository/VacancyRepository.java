package app.c.team.hackathon.repository;

import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.net.ApiProvider;
import app.c.team.hackathon.presentation.vacancies.VacancyItem;
import io.reactivex.Single;

public class VacancyRepository {

    private final ApiProvider provider;

    @Inject
    VacancyRepository(ApiProvider provider) {
        this.provider = provider;
    }

    public Single<List<VacancyItem>> loadData() {
        return provider.loadVacancyData();
    }

}
