package com.mageddo.bank.api;

import static spark.Spark.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSpark implements Spark {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloSpark.class);

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void register() {
        get("/hello", (request, response) -> {
            LOGGER.info("msg=hello");
            return helloWorldService.hello();
        });
    }

}