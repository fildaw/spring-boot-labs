package me.fil.aui_lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuiLabRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiLabRepositoryApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(@Value("${film.microservice.url}") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}

}
