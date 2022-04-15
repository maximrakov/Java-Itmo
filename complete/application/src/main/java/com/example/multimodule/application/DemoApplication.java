package com.example.multimodule.application;

import entity.Cat;
import entity.Catt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import srvs.CatSrvrs;


@EntityScan("entity")
@SpringBootApplication(scanBasePackages = {"com.example.multimodule", "srvs", "repository"})
@ComponentScan({"srvs","repository","controller"})
@RestController
//@EnableJpaRepositories({"repository", "srvs"})
@EnableJpaRepositories("repository")
public class DemoApplication {
//	private final MyService myService;
	private final CatSrvrs catSrvrs;
	@Autowired
	public DemoApplication( CatSrvrs catSrvrs) {
		this.catSrvrs = catSrvrs;
	}

	@GetMapping("/")
	public Cat home() {
		catSrvrs.saveCat(new Cat());
//		return myService.message();
		return catSrvrs.FindById(0);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
