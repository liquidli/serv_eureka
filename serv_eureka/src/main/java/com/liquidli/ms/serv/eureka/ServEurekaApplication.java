package com.liquidli.ms.serv.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServEurekaApplication.class, args);
	}
}
