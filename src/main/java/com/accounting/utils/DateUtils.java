package com.accounting.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static int getDaysDifference(Date firstDate, Date secondDate) {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date a = sdf.parse(String.format("%d/%d/%d", getMonth(firstDate), getDayOfMonth(firstDate), getYear(firstDate)));
            Date b = sdf.parse(String.format("%d/%d/%d", getMonth(secondDate), getDayOfMonth(secondDate), getYear(secondDate)));

            long diffInMillis = Math.abs(b.getTime() - a.getTime());
            return (int) TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getMonthsDifference(Date firstDate, Date secondDate) {
        var result = getDaysDifference(firstDate, secondDate) / 30;
        return (int) Math.floor(result);
    }


    public static int getYear(Date date) {
        return getCalendar(date).get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        return getCalendar(date).get(Calendar.MONTH);
    }

    public static int getDayOfMonth(Date date) {
        return getCalendar(date).get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayOfYear(Date date) {
        return getCalendar(date).get(Calendar.DAY_OF_YEAR);
    }

    private static Calendar getCalendar(Date date) {
        var c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }
}
