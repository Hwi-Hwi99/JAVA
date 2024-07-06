/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String toUTCString(ZonedDateTime localDateTime) {
        ZonedDateTime utcDateTime = localDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return utcDateTime.format(formatter);
    }

    public static ZonedDateTime fromUTCString(String utcDateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime utcDateTime = ZonedDateTime.parse(utcDateTimeStr, formatter.withZone(ZoneId.of("UTC")));
        return utcDateTime.withZoneSameInstant(ZoneId.systemDefault());
    }
}

