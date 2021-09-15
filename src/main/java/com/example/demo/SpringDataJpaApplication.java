package com.example.demo;


import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.CustomerEntity;
import com.example.repository.CustomerRepository;
@SpringBootApplication
@EnableJpaRepositories("com.example.*")
@ComponentScan(basePackages = { "com.example.*" })
@EntityScan("com.example.*")  
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(CustomerRepository repository) {
		return args -> {
			insertCustomer(repository);
			getCustomer(repository);
			updateCustomer(repository);
			deleteCustomer(repository);
		};
	}

	private void insertCustomer(CustomerRepository repository) {
		CustomerEntity entity = new CustomerEntity("Dat", 30, "Male");
		repository.createCustomer(entity.getName(), entity.getAge(), entity.getGender());;

	}

	private void getCustomer(CustomerRepository repository) {
		CustomerEntity entity = repository.findOneCustomer(1);
		System.out.println(entity.getAge());
	}

	private void updateCustomer(CustomerRepository repository) {
		
		repository.updateCustomer((long) 1, "TD", 25, "male");
	}

	private void deleteCustomer(CustomerRepository repository) {
		repository.deleteCustomer(1);
	}}
