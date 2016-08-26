package com.mageddo.bank.api.controller;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mageddo.bank.api.config.Spark;
import com.mageddo.bank.api.entity.CustomerEntity;
import com.mageddo.bank.api.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerSparkController implements Spark {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerSparkController.class);

    @Autowired
    private CustomerService customerService;

    @Override
    public void register() {
        get("/customer/:customerName", (request, response) -> {
            final String name = request.params(":customerName");
            final List<CustomerEntity> customerEntities = customerService.findByName(name);
            response.type("application/json");
            return new ObjectMapper().writeValueAsString(customerEntities);
        });
        post("/customer/", (request, response) -> {
            final CustomerEntity customerEntity = new ObjectMapper().readValue(response.body(), CustomerEntity.class);
            customerService.createCustomer(customerEntity);
            return "";
        });
        get("/hello", (request, response) -> {
            LOGGER.info("msg=hello");
            return "Hello World from controller!!!";
        });
    }

}