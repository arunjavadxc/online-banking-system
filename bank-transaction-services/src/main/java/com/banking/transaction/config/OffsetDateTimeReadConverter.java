package com.banking.transaction.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@ReadingConverter
public class OffsetDateTimeReadConverter implements Converter<String, OffsetDateTime> {
    @Override
    public OffsetDateTime convert(String source) {
        return OffsetDateTime.parse(source, DateTimeFormatter.ISO_DATE_TIME);
    }
}
