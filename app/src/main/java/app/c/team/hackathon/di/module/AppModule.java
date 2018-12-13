package app.c.team.hackathon.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import app.c.team.hackathon.model.data.AppSchedulers;
import app.c.team.hackathon.model.data.Preferences;
import app.c.team.hackathon.model.data.ResourcesManager;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContex() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    ResourcesManager provideResourseManager() {
        return new ResourcesManager(application.getApplicationContext());
    }


    @Provides
    @Singleton
    Preferences providePreferences() {
        return new Preferences(application.getApplicationContext());
    }

    @Provides
    @Singleton
    AppSchedulers provideAppSchedulers() {
        return new AppSchedulers();
    }

}
