package com.demo.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : csj
 * @apiNote :
 * @date :2019-07-17
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ServiceAApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}
}
