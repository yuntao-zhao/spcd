package com.christy.spcd.registry;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class RegistryStartup {

	
	public static void main(String[] args) {
		new SpringApplicationBuilder(RegistryStartup.class).run(args);
	}
}
