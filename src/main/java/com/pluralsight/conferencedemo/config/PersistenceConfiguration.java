package com.pluralsight.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static java.lang.System.getenv;

@Configuration
public class PersistenceConfiguration {
    //  @Bean
    //  public DataSource dataSource() {
    //        DataSourceBuilder builder = DataSourceBuilder.create();
    //        builder.url("jdbc:postgresql://localhost:5432/conference_app");
    //        builder.username(System.getenv("DB_USR"));
    //        builder.password(System.getenv("DB_PASS"));
    //        System.out.println("My custom datasource bean has been initialzed and set");
    //        return builder.build();
    //    }
}
