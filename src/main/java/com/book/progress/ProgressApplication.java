package com.book.progress;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API Backend de incentivo à leitura",
				version = "1.0",
				description = "Através de um sistema de recompensas, essa API tem o intuito de incentivar a leitura",
				contact = @Contact(
						name = "João Vitor",
						email = "teste@gmail.com",
						url = "https://www.google.com")
		)
)

@SpringBootApplication
public class ProgressApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgressApplication.class, args);
	}

}
