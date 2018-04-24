package com.liquidli.ms.serv.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableEurekaServer
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ServEurekaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServEurekaApplication.class, args);

//		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("admin", "123",
//				AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
	}
}
