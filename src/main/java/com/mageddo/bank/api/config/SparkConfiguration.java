package com.mageddo.bank.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SparkConfiguration {

    @Autowired(required = false)
    private List<Spark> sparks = new ArrayList<>();

    @Bean
    CommandLineRunner sparkRunner() {
        return args -> sparks.stream().forEach( spark -> spark.register());
    }

}
