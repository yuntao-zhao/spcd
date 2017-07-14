package com.christy.spcd.mobile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MobileStartup {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MobileStartup.class).run(args);
	}
}
