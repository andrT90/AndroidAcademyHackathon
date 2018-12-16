package app.c.team.hackathon.presentation.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.navigation.HackathonNavigator;
import ru.terrakok.cicerone.NavigatorHolder;

public class LoginActivity extends AppCompatActivity {

    HackathonNavigator navigator;

    @Inject
    NavigatorHolder navigatorHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ComponentsHolder.getInstance().appComponent().inject(this);
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, LoginFragment.newInstance())
                    .commitNow();
        }

        if (navigator == null)
            navigator = new HackathonNavigator(this, getSupportFragmentManager(), android.R.id.content);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}
