package com.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @author : csj
 * @apiNote : ZipKin 链路追踪
 * @date :2019-07-17
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipKinServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipKinServerApplication.class, args);
	}
}
