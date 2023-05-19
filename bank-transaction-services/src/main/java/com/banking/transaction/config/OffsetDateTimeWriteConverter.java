package com.banking.transaction.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WritingConverter
public class OffsetDateTimeWriteConverter implements Converter<OffsetDateTime, String> {
    @Override
    public String convert(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
