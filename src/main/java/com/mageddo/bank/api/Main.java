package com.mageddo.bank.api;

import static spark.Spark.get;

/**
 * Created by elvis on 26/08/16.
 */
public class Main {
	public static void main(String[] args) {
		get("/hello", (request, response) -> "Hello World!");
	}
}
