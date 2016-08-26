package com.mageddo.bank.api;

import static spark.Spark.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by elvis on 26/08/16.
 */
public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		get("/hello", (request, response) -> {
			LOGGER.info("msg=hello");
			return "Hello World!";
		});
	}
}
