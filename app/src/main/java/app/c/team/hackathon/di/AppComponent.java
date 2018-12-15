package app.c.team.hackathon.di;

import javax.inject.Singleton;

import app.c.team.hackathon.di.module.AppModule;
import app.c.team.hackathon.di.module.NavigationModule;
import app.c.team.hackathon.di.module.NetworkModule;
import app.c.team.hackathon.model.navigation.LocalNavigationModule;
import app.c.team.hackathon.presentation.base.TabContainerFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavActivity;
import app.c.team.hackathon.presentation.event.EventPresenter;
import app.c.team.hackathon.presentation.info.EventInfoPresenter;
import app.c.team.hackathon.presentation.links.EventLinksPresenter;
import app.c.team.hackathon.presentation.notes.EventNotesPresenter;
import dagger.Component;

@Component(modules = {
        AppModule.class, NetworkModule.class,
        NavigationModule.class, LocalNavigationModule.class})
@Singleton
public interface AppComponent {
    void inject(TabContainerFragment tabContainerFragment);

    void inject(BottomNavActivity bottomNavActivity);

    void inject(EventPresenter eventPresenter);

    void inject(EventInfoPresenter eventInfoPresenter);

    void inject(EventLinksPresenter eventLinksPresenter);

    void inject(EventNotesPresenter eventNotesPresenter);
}
