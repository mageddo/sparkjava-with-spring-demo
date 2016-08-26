package com.mageddo.bank.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by elvis on 26/08/16.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = SparkConfiguration.class)
@Import(SparkConfiguration.class)
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
