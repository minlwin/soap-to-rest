package com.jdc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.demo.repo.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class OneToManyQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyQueryApplication.class, args);
	}

}
