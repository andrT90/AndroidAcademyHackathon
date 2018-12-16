package app.c.team.hackathon.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private DateUtil() {
        //no instance
    }

    /**
     * Выдает месяц от даты
     *
     * @param time время в секундах
     * @return месяц
     */
    public static String getMonth(long time) {
        return new SimpleDateFormat("MMMM", Locale.getDefault()).format(new Date(time * 1000));
    }

    /**
     * Выдает день от даты
     *
     * @param time время в секундах
     * @return день
     */
    public static String getDayOfMonth(long time) {
        return new SimpleDateFormat("dd", Locale.getDefault()).format(new Date(time * 1000));
    }

    /**
     * Выдает время от даты
     *
     * @param time время в секундах
     * @return вреся в формате HH:mm
     */
    public static String getTime(long time) {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(time * 1000));
    }

    public static String getDate(long time) {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date(time * 1000));
    }


    public static int compareToNow(long time) {
        return Calendar.getInstance().getTime().compareTo(new Date(time * 1000));
    }
}
