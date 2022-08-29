package com.vijay.comp.ServiceRegistry2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistry2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistry2Application.class, args);
	}

}
