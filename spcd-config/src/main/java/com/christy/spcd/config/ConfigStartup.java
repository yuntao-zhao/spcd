package com.christy.spcd.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigStartup {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigStartup.class).web(true).run(args);
	}
}
