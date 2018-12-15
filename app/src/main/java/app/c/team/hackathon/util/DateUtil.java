package app.c.team.hackathon.util;

import java.text.SimpleDateFormat;
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
    public String getMonth(int time) {
        return new SimpleDateFormat("MMMM", Locale.getDefault()).format(new Date(time * 1000));
    }

    /**
     * Выдает день от даты
     *
     * @param time время в секундах
     * @return день
     */
    public String getDayOfMonth(int time) {
        return new SimpleDateFormat("dd", Locale.getDefault()).format(new Date(time * 1000));
    }

    /**
     * Выдает время от даты
     *
     * @param time время в секундах
     * @return вреся в формате HH:mm
     */
    public String getTime(int time) {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(time * 1000));
    }
}
