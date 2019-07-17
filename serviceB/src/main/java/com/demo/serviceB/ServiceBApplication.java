package com.demo.serviceB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : csj
 * @apiNote :
 * @date :2019-07-17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}
}
