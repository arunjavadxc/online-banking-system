package com.banking.transaction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ConverterConfig extends AbstractMongoClientConfiguration {
    @Override
    public MongoCustomConversions customConversions(){
        return new MongoCustomConversions(
                Arrays.asList(new OffsetDateTimeReadConverter(),new OffsetDateTimeWriteConverter())
        );
    }

    protected String getDatabaseName() {
        return "TransactionDB";
    }

//    @Override
//    protected void configureConverters(MongoCustomConversions.MongoConverterConfigurationAdapter converterConfigurationAdapter) {
//        converterConfigurationAdapter.registerConverters(customConversions());
//        super.configureConverters(converterConfigurationAdapter);
//    }
}

