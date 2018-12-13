package app.c.team.hackathon.model.data;

import android.content.Context;
import android.support.annotation.StringRes;

public class ResourcesManager {
    private final Context context;

    public ResourcesManager(Context context) {
        this.context = context;
    }

    public String getString(@StringRes int id) {
        return context.getString(id);
    }
}
