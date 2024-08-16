package com.bradjaffke.spring_playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class SpringPlaygroundApplication {


    public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);

		WebClient webClient = WebClient.create("https://api.chucknorris.io/jokes/random");

		final String chuckNorrisBaseAPIURL = "https://api.chucknorris.io/jokes/random";

		String chuckNorrisJoke = webClient.get()
				.uri(chuckNorrisBaseAPIURL)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		System.out.println(chuckNorrisJoke);

	}
}
