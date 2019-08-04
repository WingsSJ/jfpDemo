package com.demo.channel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : csj
 * @apiNote :
 * @date :2019-07-17
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
public class ChannelServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChannelServiceApplication.class, args);
	}
}
