package app.c.team.hackathon.di.module;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import app.c.team.hackathon.BuildConfig;
import app.c.team.hackathon.model.data.AppSchedulers;
import app.c.team.hackathon.model.data.Preferences;
import app.c.team.hackathon.model.data.net.AndroidAcademyApi;
import app.c.team.hackathon.model.data.net.interceptor.AuthorizationInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @NonNull
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @NonNull
    @Singleton
    OkHttpClient provideOkHttpClient(AuthorizationInterceptor authorizationInterceptor) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(authorizationInterceptor)
                .addInterceptor(logging)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .followRedirects(false);

        return builder.build();
    }


    @Provides
    @NonNull
    @Singleton
    AndroidAcademyApi provideIsopApi(OkHttpClient okHttpClient,
                                     AppSchedulers schedulers,
                                     Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(AndroidAcademyApi.SERVER)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(schedulers.io()))
                .client(okHttpClient)
                .build()
                .create(AndroidAcademyApi.class);
    }
}
