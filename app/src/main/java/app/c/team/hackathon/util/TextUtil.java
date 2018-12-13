package app.c.team.hackathon.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public class TextUtil {
    private TextUtil() {
        //no instance
    }

    public static Boolean isNotEmpty(@Nullable String string) {
        return !TextUtils.isEmpty(string);
    }
}
