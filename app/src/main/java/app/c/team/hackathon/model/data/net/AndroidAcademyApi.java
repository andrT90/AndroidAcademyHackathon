package app.c.team.hackathon.model.data.net;

import java.util.List;

import app.c.team.hackathon.model.domain.Event;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AndroidAcademyApi {

    static final String PATH = "";
    static final String SERVER = "http://aa.swapp.ga/";

    @POST("auth")
    Single<BaseResponse<TokenResult>> login(@Query("email") String email);

    @GET
    Single<BaseResponse<List<Event>>> getEventList();

    @GET("event")
    Single<BaseResponse<Event>> getEvent(@Query("event_id") int id);
}
