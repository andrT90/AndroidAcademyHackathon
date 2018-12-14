package app.c.team.hackathon.di;

import javax.inject.Singleton;

import app.c.team.hackathon.di.module.AppModule;
import app.c.team.hackathon.model.navigation.LocalNavigationModule;
import app.c.team.hackathon.di.module.NavigationModule;
import app.c.team.hackathon.di.module.NetworkModule;
import app.c.team.hackathon.presentation.base.TabContainerFragment;
import dagger.Component;

@Component(modules = {
        AppModule.class, NetworkModule.class,
        NavigationModule.class, LocalNavigationModule.class})
@Singleton
public interface AppComponent {
    void inject(TabContainerFragment tabContainerFragment);
}
