package com.christy.spcd.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminStartup {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AdminStartup.class).web(true).run(args);
	}
}
