package com.practice.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.practice.dao.EmployeeDAO;
import com.practice.dao.EmployeeDAOImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class EmployeeService {
	@Autowired
	private Environment env;
	
	// Fetch SQL DB properties from the application.properties file
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	} 
	
	@Bean
	public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOImpl(getDataSource());
    }
}
