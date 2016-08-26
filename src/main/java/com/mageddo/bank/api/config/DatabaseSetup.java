package com.mageddo.bank.api.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 8/26/16 1:42 PM
 */
@Component
public class DatabaseSetup {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSetup.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void construct() {

        LOGGER.info("status=begin");
        jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames
                .forEach(name -> LOGGER.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
        LOGGER.info("status=success");

    }
}
