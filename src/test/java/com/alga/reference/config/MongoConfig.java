package com.alga.reference.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    @Bean
    @Profile("workaround")
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory factory, MongoMappingContext mappingContext) {
        // GuestDbRefResolver is a workaround for loading of old data: guests with DBRef-s.
        // With DefaultDbRefResolver loading of old data is failed with SpelEvaluationException and the following message:
        //      "EL1008E: Property or field '_id' cannot be found on object of type 'com.mongodb.DBRef' - maybe not public or not valid?".
        // To check it comment @ActiveProfiles(value = "workaround") on a test class com.alga.reference.ReferenceApplicationTests
        // and run test com.alga.reference.ReferenceApplicationTests.testLoadGuestWithDbRef
        DbRefResolver dbRefResolver = new GuestDbRefResolver(factory);
        return new MappingMongoConverter(dbRefResolver, mappingContext);
    }

}
