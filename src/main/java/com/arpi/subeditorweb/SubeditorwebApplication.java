package com.arpi.subeditorweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.arpi"})
public class SubeditorwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubeditorwebApplication.class, args);
	}

}
