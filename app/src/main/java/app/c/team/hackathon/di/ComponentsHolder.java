package app.c.team.hackathon.di;

import android.app.Application;

import app.c.team.hackathon.di.module.AppModule;

public class ComponentsHolder {
    private static volatile ComponentsHolder instance = new ComponentsHolder();

    public static ComponentsHolder getInstance() {
        return instance;
    }

    private AppComponent appComponent;


    public AppComponent appComponent() {
        return appComponent;
    }

    public void initAppComponent(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
