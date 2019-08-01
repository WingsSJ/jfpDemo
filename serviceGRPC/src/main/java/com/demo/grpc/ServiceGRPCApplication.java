package com.demo.grpc;

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
public class ServiceGRPCApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceGRPCApplication.class, args);
	}
}
