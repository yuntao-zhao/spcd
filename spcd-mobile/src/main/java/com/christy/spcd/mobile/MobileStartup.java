package com.christy.spcd.mobile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MobileStartup {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MobileStartup.class).run(args);
	}
}
