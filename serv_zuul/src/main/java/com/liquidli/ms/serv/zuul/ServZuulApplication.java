package com.liquidli.ms.serv.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ServZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServZuulApplication.class, args);
	}
}
