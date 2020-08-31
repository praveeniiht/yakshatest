package com.examples.simplenote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.example"})
@EnableJpaRepositories(basePackages = "com.example.repo")
@EntityScan("com.example.model")

public class SimplenoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplenoteApplication.class, args);
	}

}
