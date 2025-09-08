package com.lyxh.linn.common.core.utils.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public abstract class LocalDateFormatUtils {

    public static String format(TemporalAccessor temporal, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(temporal);
    }

    public static String formatDate(LocalDateTime dateTime) {
        return DateFormatUtils.DEFAULT_DATE_FORMATTER.format(dateTime);
    }

    public static String formatDate(LocalDate date) {
        return DateFormatUtils.DEFAULT_DATE_FORMATTER.format(date);
    }

    public static String formatDate() {
        return DateFormatUtils.DEFAULT_DATE_FORMATTER.format(LocalDate.now());
    }

    public static String formatTime(LocalDateTime dateTime) {
        return DateFormatUtils.DEFAULT_TIME_FORMATTER.format(dateTime);
    }

    public static String formatTime(LocalTime time) {
        return DateFormatUtils.DEFAULT_TIME_FORMATTER.format(time);
    }

    public static String formatTime() {
        return DateFormatUtils.DEFAULT_TIME_FORMATTER.format(LocalTime.now());
    }

    public static String formatDatetime(LocalDateTime dateTime) {
        return DateFormatUtils.DEFAULT_DATETIME_FORMATTER.format(dateTime);
    }

    public static String formatDatetime() {
        return DateFormatUtils.DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DateFormatUtils.DEFAULT_DATE_FORMATTER);
    }

    public static LocalTime parseTime(String timeStr) {
        return LocalTime.parse(timeStr, DateFormatUtils.DEFAULT_TIME_FORMATTER);
    }

    public static LocalDateTime parseDatetime(String datetimeStr) {
        return LocalDateTime.parse(datetimeStr, DateFormatUtils.DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 使用指定模式解析字符串为 LocalDateTime
     */
    public static LocalDateTime parse(String datetimeStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(datetimeStr, formatter);
    }

    /**
     * 将 {@link Date} 转换为 {@link LocalDateTime}，使用系统默认时区
     */
    public static LocalDateTime from(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 将 {@link LocalDateTime} 转换为 {@link Date}，使用系统默认时区
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
