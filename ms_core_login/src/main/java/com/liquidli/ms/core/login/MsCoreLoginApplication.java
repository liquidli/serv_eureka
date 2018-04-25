package com.liquidli.ms.core.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCoreLoginApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MsCoreLoginApplication.class, args);
	}
}
