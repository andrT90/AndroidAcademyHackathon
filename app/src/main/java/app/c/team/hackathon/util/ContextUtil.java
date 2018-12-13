package app.c.team.hackathon.util;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;

public class ContextUtil {
    private ContextUtil() {
        //no instance
    }

    public static int dpToPixelOffset(@NonNull Context context, @DimenRes int resId) {
        return context.getResources().getDimensionPixelOffset(resId);
    }

    public static float dpToPixel(@NonNull Context context, @DimenRes int resId) {
        return context.getResources().getDimension(resId);
    }
}
