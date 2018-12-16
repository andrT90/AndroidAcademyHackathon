package app.c.team.hackathon.model.data.net;

import java.util.List;

import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.model.domain.User;
import app.c.team.hackathon.model.domain.Vacancy;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AndroidAcademyApi {

    static final String PATH = "";
    static final String SERVER = "http://aa.swapp.ga/";

    @POST("auth")
    Single<BaseResponse<TokenResult>> login(@Query("email") String email);

    @GET("events")
    Single<BaseResponse<List<Event>>> getEventList();

    @GET("mentors")
    Single<BaseResponse<List<User>>> getMentorList();

    @GET("vacancies")
    Single<BaseResponse<List<Vacancy>>> getVacancyList();

    @GET("event")
    Single<BaseResponse<Event>> getEvent(@Query("event_id") int id);

}
