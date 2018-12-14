package app.c.team.hackathon;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import app.c.team.hackathon.di.ComponentsHolder;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        ComponentsHolder.getInstance().initAppComponent(this);
    }
}
