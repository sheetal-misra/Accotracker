package com.accolite;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AccoTrackerApplication  {

	
	
	public static void main(String[] args) {
		SpringApplication.run(AccoTrackerApplication.class, args);
		 
	}

}
