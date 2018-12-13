package app.c.team.hackathon.model.data.net;

import io.reactivex.Single;
import retrofit2.http.POST;

public interface AndroidAcademyApi {

    static final String PATH = "";
    static final String SERVER = "";

    @POST(PATH)
    Single<String> login();


}
