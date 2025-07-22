package com.limyel.linn.common.core.utils.local;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class DateFormatUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHM_FORMAT = "yyyy-MM-dd HH:mm";

    public static final DateTimeFormatter DEFAULT_DATE_FORMATER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)
            .withZone(ZoneId.systemDefault());
    public static final DateTimeFormatter DEFAULT_TIME_FORMATER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)
            .withZone(ZoneId.systemDefault());
    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT)
            .withZone(ZoneId.systemDefault());
    public static final DateTimeFormatter YMDHM_FORMATER = DateTimeFormatter.ofPattern(YMDHM_FORMAT)
            .withZone(ZoneId.systemDefault());

}
