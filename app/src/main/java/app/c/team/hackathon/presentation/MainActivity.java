package app.c.team.hackathon.presentation;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

import app.c.team.hackathon.R;

public class MainActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
