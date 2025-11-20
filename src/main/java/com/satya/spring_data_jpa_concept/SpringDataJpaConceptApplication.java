package com.satya.spring_data_jpa_concept;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaConceptApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (StudentRepository studentRepository){
		return args -> {
			Student maria = new Student("Satya", "Vadapalli","satyavadapalli@gmail.com",24);
			studentRepository.save(maria);
		};
	}

}
