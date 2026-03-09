package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductRepository productRepository, PatientRepository patientRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					new Product(null, "Laptop", 1200.0, 5),
					new Product(null, "Smartphone", 800.0, 12),
					new Product(null, "Headphones", 150.0, 20)
			));

			patientRepository.saveAll(List.of(
					new Patient(null, "Youssef", Date.valueOf(LocalDate.of(2000, 5, 12)), false, 12, null),
					new Patient(null, "Amina", Date.valueOf(LocalDate.of(1998, 11, 3)), true, 8, null),
					new Patient(null, "Karim", Date.valueOf(LocalDate.of(1995, 2, 21)), false, 15, null),
					new Patient(null, "Salma", Date.valueOf(LocalDate.of(2002, 8, 30)), true, 5, null),
					new Patient(null, "Hassan", Date.valueOf(LocalDate.of(1989, 1, 9)), false, 19, null),
					new Patient(null, "Nadia", Date.valueOf(LocalDate.of(1993, 6, 17)), true, 3, null),
					new Patient(null, "Omar", Date.valueOf(LocalDate.of(2001, 12, 25)), false, 10, null)
			));

			productRepository.findAll().forEach(System.out::println);
		};
	}

}
