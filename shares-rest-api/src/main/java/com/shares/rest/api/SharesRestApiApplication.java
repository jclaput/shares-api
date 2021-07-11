package com.shares.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SharesRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharesRestApiApplication.class, args);
	}

}
