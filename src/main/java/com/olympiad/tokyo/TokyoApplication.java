package com.olympiad.tokyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TokyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokyoApplication.class, args);
	}
}
