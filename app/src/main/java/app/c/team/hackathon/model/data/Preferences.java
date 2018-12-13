package app.c.team.hackathon.model.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

public class Preferences {
    private static final String KEY_TOKEN = "token";

    private final SharedPreferences sharedPreferences;

    public Preferences(@NonNull Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getToken() {
        return sharedPreferences
                .getString(KEY_TOKEN, "");
    }

    public void setToken(@NonNull String token) {
        sharedPreferences
                .edit()
                .putString(KEY_TOKEN, token)
                .apply();
    }
}
