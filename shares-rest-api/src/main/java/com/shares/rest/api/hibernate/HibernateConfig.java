package com.shares.rest.api.hibernate;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Autowired
	private org.springframework.core.env.Environment environment;

	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.shares.rest.api.entity"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean(name="transactionManager")
	public TransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		
		return dataSource;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.put(Environment.DIALECT, environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		hibernateProperties.put(Environment.SHOW_SQL, environment.getRequiredProperty("spring.jpa.show-sql"));
		hibernateProperties.put(Environment.FORMAT_SQL, environment.getRequiredProperty("spring.jpa.show-sql"));
		hibernateProperties.put(Environment.HBM2DDL_AUTO, environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		
		return hibernateProperties;
	}
}
