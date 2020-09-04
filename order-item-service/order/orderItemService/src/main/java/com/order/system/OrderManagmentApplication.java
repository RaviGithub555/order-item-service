package com.order.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication 
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration
@EnableJpaRepositories("com.order.system.repository")
public class OrderManagmentApplication implements CommandLineRunner{
	
	
	
	 protected static Logger logger = LogManager.getLogger(OrderManagmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderManagmentApplication.class, args);
		
	}

	
	public void run(String... args) throws Exception {
		try {
			   Long start = System.currentTimeMillis();
			
		} catch(Exception e) {
		}
		
        }
		
}


