package app.c.team.hackathon.di;

import android.app.Application;

import app.c.team.hackathon.di.module.AppModule;

public class ComponentsHolder {
    private static volatile ComponentsHolder instance;

    public static ComponentsHolder getInstance() {
        ComponentsHolder localInstance = instance;
        if (localInstance == null) {
            synchronized (ComponentsHolder.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ComponentsHolder();
                }
            }
        }
        return localInstance;
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
