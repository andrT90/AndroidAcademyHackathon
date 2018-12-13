package app.c.team.hackathon.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

import io.reactivex.annotations.Nullable;

public class MessageDelegate {
    @Nullable
    private final Context context;

    public MessageDelegate(@Nullable Context context) {
        this.context = context;
    }

    public void showError(@StringRes int id) {
        if (context != null) Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
    }

    public void showError(@NonNull String text) {
        if (context != null) Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(@NonNull String text) {
        if (context != null) Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(@StringRes int id) {
        if (context != null) Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
    }
}
