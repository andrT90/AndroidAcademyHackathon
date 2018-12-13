package app.c.team.hackathon.util;

import android.support.annotation.NonNull;
import android.view.View;

public class ViewUtil {
    private ViewUtil() {
        //no instance
    }

    public static void viewSetVisibleOrGone(@NonNull View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public static void viewSetVisibleOrInvisible(@NonNull View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    public static boolean viewIsVisible(@NonNull View view) {
        return view.getVisibility() == View.VISIBLE;
    }
}
