package app.c.team.hackathon.model.data.net;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AndroidAcademyApi {

    static final String PATH = "";
    static final String SERVER = "http://aa.swapp.ga/";

    @POST("auth")
    Single<BaseResponse<TokenResult>> login(@Query("email") String email);

}
