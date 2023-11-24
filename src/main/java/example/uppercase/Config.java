package example.uppercase;

import java.util.function.Function;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@Configuration
public class Config {

	private final SomeService someService;

	public Config(SomeService someService) {
		this.someService = someService;
	}

	@Bean
	public Function<String, String> echo() {
		return payload -> payload;
	}

	@Bean
	public Function<Mono<String>, Mono<String>> uppercase() {
		return payload -> payload
				.map(someService::toUpperCase)
				.doOnNext(System.out::println);
	}
	@Bean
	public Function<Mono<String>, Mono<String>> uppercaseMono() {
		return payload -> payload
				.map(someService::toUpperCase)
				.doOnNext(System.out::println);
	}
}

