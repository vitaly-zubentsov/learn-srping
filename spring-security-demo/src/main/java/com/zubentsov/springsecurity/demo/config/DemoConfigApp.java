package com.zubentsov.springsecurity.demo.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zubentsov.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoConfigApp {

	// set up variable to hold the properties

	@Autowired
	private Environment env;

	// set up logger for diagnostics

	private Logger logger = Logger.getLogger(this.getClass().getName());

	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// define a bean for our security datasource

	@Bean
	public DataSource securityDataSource() {

		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set jdbs driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		// log the connection properties
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));

		// set database connection properties
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool properties

		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;

	}

	public int getIntProperty(String nameOfProperty) {
		return Integer.parseInt(env.getProperty(nameOfProperty));
	}

}
