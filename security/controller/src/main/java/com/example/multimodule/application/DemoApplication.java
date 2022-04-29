package com.example.multimodule.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import service.CatService;


@EntityScan("entity")
@SpringBootApplication(scanBasePackages = {"service", "repository", "security"})
@ComponentScan({"service","repository","controller","security"})
@RestController
@EnableJpaRepositories("repository")
public class DemoApplication {
	private final CatService catService;

	@Autowired
	public DemoApplication(CatService catService) {
		this.catService = catService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}