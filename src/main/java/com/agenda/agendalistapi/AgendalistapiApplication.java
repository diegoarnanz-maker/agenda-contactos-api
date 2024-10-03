package com.agenda.agendalistapi;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.agenda.agendalistapi.entity.Contact;
import com.agenda.agendalistapi.repository.ContactRepository;

@SpringBootApplication
public class AgendalistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendalistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return (String...args) -> {
				List<Contact> contacts = Arrays.asList(
						new Contact("Diego", "diego@gmail.com", LocalDateTime.now()),
						new Contact("María", "maria@gmail.com", LocalDateTime.of(2023, 8, 1, 10, 30)),
						new Contact("Juan", "juan@hotmail.com", LocalDateTime.of(2023, 9, 15, 14, 45)),
						new Contact("Laura", "laura@yahoo.com", LocalDateTime.of(2023, 7, 20, 9, 20)),
						new Contact("Pedro", "pedro@gmail.com", LocalDateTime.of(2023, 10, 5, 16, 55)),
						new Contact("Ana", "ana@outlook.com", LocalDateTime.of(2023, 11, 10, 12, 15))
						);
				contactRepository.saveAll(contacts);
		};
	}

}
