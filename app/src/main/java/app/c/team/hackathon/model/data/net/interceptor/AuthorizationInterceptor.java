package app.c.team.hackathon.model.data.net.interceptor;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import app.c.team.hackathon.model.data.Preferences;
import app.c.team.hackathon.util.TextUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {
    private final Preferences preferences;

    @Inject
    public AuthorizationInterceptor(Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder();
        String token = preferences.getToken();
        if (TextUtil.isNotEmpty(token)) builder.addHeader("Authorization", "Bearer " + token);

        return chain.proceed(builder.build());
    }
}
