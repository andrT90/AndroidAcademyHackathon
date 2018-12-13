package app.c.team.hackathon.di.module;

import javax.inject.Singleton;

import app.c.team.hackathon.model.data.LocalCiceroneHolder;
import dagger.Module;
import dagger.Provides;

@Module
public class LocalNavigationModule {

    @Provides
    @Singleton
    LocalCiceroneHolder provideLocalCiceroneHolder() {
        return new LocalCiceroneHolder();
    }
}
