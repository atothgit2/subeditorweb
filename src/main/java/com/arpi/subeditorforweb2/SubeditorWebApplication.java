package com.arpi.subeditorforweb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.arpi"})
public class SubeditorWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubeditorWebApplication.class, args);
	}
}
