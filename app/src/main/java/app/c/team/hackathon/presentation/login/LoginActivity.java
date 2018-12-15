package app.c.team.hackathon.presentation.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.c.team.hackathon.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, LoginFragment.newInstance())
                    .commitNow();
        }
    }
}
