package com.example.demo.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeWrapper {

    private static LocalDateTime instant;
    private static Duration offset;

    public static void setFixed(Instant instant) {
        DateTimeWrapper.instant = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        offset = null;
    }

    public static void setOffset(Duration duration) {
        offset = duration;
        instant = null;
    }

    public static LocalDateTime currentDateTime() {
        if (instant != null) {
            return instant;
        } else if (offset != null) {
            return LocalDateTime.now().plus(offset);
        } else {
            return LocalDateTime.now();
        }
    }
}