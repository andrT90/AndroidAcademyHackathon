package app.c.team.hackathon.model.data.net;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.model.domain.ResourceLink;
import app.c.team.hackathon.model.domain.User;
import app.c.team.hackathon.model.domain.Vacancy;
import app.c.team.hackathon.presentation.links.EventLinkItem;
import app.c.team.hackathon.presentation.mentors.MentorItem;
import app.c.team.hackathon.presentation.vacancies.VacancyItem;
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

    public Single<List<EventLinkItem>> getEventLinkList(int eventId) {
        return api
                .getResourceLinkList(eventId)
                .map(baseResponse -> {
                    List<EventLinkItem> vacancyItems = new ArrayList<>();
                    for (ResourceLink resourceLink : baseResponse.getData()) {
                        vacancyItems.add(new EventLinkItem(resourceLink));
                    }
                    return vacancyItems;
                });
    }

    public Single<List<MentorItem>> loadMentorData() {
        return api
                .getMentorList()
                .map(baseResponse -> {
                    List<MentorItem> mentorItems = new ArrayList<>();
                    for (User user : baseResponse.getData()) {
                        mentorItems.add(new MentorItem(user));
                    }
                    return mentorItems;
                });
    }

    public Single<List<VacancyItem>> loadVacancyData() {
        return api
                .getVacancyList()
                .map(baseResponse -> {
                    List<VacancyItem> vacancyItems = new ArrayList<>();
                    for (Vacancy vacancy : baseResponse.getData()) {
                        vacancyItems.add(new VacancyItem(vacancy));
                    }
                    return vacancyItems;
                });
    }

    public Single<Event> getEvent(int id) {
        return api
                .getEvent(id)
                .map(BaseResponse::getData);

    }

}
