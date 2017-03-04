package com.alife.Handler;

import com.alife.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by macbook on 4/3/17.
 */
public class DateTimeHandler {

    public static String getCurrentDateAsISO8601(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(Constants.DATEFORMAT_ISO8601,
                Locale.getDefault());
        return df.format(date);
    }

    public static Long currentTimeInMillis() {
        return Instant.now().toEpochMilli();
    }

    public static String dateToISO8601(Date date){
        DateFormat df = new SimpleDateFormat(Constants.DATEFORMAT_ISO8601,
                Locale.getDefault());
        return df.format(date);
    }

    public static Long countDaysBetweenDates(Date firstDate, Date secondDate){
        return Math.abs(ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant()));
    }

    public static Long countHoursBetweenDates(Date firstDate, Date secondDate){
        return Math.abs(ChronoUnit.HOURS.between(firstDate.toInstant(), secondDate.toInstant()));
    }

}
