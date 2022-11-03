package com.epam.spring.library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		log.info("Start Library spring application");
		SpringApplication.run(LibraryApplication.class, args);
	}

}
