package com.mageddo.bank.api.dao;

import java.util.List;

import com.mageddo.bank.api.entity.CustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by elvis on 13/08/16.
 */

@Repository
public class CustomerDAOPostgre implements CustomerDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAOPostgre.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerEntity> findByName(String name) {
		LOGGER.info("status=begin,name={}",  name);
		final List<CustomerEntity> customerEntities = jdbcTemplate.query(
				"SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[]{name},
				(rs, rowNum) -> new CustomerEntity(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		);
		LOGGER.info("status=success");
		return customerEntities;
	}

	@Override
	public void create(CustomerEntity customerEntity) {
		jdbcTemplate.update("INSERT INTO customers (first_name, last_name) VALUES (?, ?)", customerEntity.getFirstName(),
				customerEntity.getLastName());


	}

	@Override
	public void update(CustomerEntity customerEntity) {
		jdbcTemplate.update("UPDATE customers SET first_name=?, last_name=? WHERE id = ?",
				customerEntity.getFirstName(), customerEntity.getLastName(), customerEntity.getId());
	}
}
