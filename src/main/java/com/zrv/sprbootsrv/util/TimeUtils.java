package com.zrv.sprbootsrv.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class TimeUtils {

    private static volatile LocalDateTime dateTime;

    public static LocalDateTime getDateTime() {
        if (dateTime != null) {
            return dateTime;
        }
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    public static LocalDate getDate() {
        if (dateTime != null) {
            return dateTime.toLocalDate();
        }
        return LocalDate.now(ZoneOffset.UTC);
    }

    public static void setDateTime(LocalDateTime dt) {
        if (dt != null) {
            dt.atZone(ZoneOffset.UTC);
        }
        dateTime = dt;
    }

    public static LocalTime getTime() {
        if (dateTime != null) {
            return dateTime.toLocalTime();
        }
        return LocalTime.now(ZoneOffset.UTC);
    }

    public static void reset() {
        dateTime = null;
    }
}
