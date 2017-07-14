package com.christy.spcd.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OrderStartup extends SpringBootServletInitializer{

	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderStartup.class).web(true).run(args);
	}
}
