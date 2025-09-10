package com.haoyuan.linn.common.core.utils.json;

import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.haoyuan.linn.common.core.utils.local.DateFormatUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeModule extends SimpleModule {

    public LocalDateTimeModule() {
        super(PackageVersion.VERSION);
        this.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateFormatUtils.DEFAULT_DATETIME_FORMATTER));
        this.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateFormatUtils.DEFAULT_DATE_FORMATTER));
        this.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateFormatUtils.DEFAULT_TIME_FORMATTER));
        this.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateFormatUtils.DEFAULT_DATETIME_FORMATTER));
        this.addSerializer(LocalDate.class, new LocalDateSerializer(DateFormatUtils.DEFAULT_DATE_FORMATTER));
        this.addSerializer(LocalTime.class, new LocalTimeSerializer(DateFormatUtils.DEFAULT_TIME_FORMATTER));
    }

}
