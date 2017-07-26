package com.christy.spcd.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class GatewayStartup {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayStartup.class).web(true).run(args);
	}
}
