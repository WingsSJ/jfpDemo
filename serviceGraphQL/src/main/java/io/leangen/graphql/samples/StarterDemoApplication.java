package io.leangen.graphql.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class StarterDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarterDemoApplication.class, args);
	}
}
