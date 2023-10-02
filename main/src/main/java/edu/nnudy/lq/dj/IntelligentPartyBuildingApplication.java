package edu.nnudy.lq.dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class IntelligentPartyBuildingApplication {
	
	public static void main(final String... arguments) {
		final var applicationContext = SpringApplication.run(
				IntelligentPartyBuildingApplication.class,
				arguments
		);
		System.out.println(
				Stream.of(applicationContext.getBeanDefinitionNames())
						.sorted(String::compareTo)
						.collect(Collectors.joining(System.lineSeparator()))
		);
	}
}
