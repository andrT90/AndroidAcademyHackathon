package app.c.team.hackathon;

import android.content.Context;
import android.content.Intent;

import app.c.team.hackathon.presentation.bottom.BottomNavActivity;
import app.c.team.hackathon.presentation.login.LoginActivity;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public final class LoginScreen extends SupportAppScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, LoginActivity.class);
        }
    }

    public final class BottomNavScreen extends SupportAppScreen{
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, BottomNavActivity.class);
        }
    }
}
