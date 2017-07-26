package com.christy.spcd.mobile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MobileStartup {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MobileStartup.class).web(true).run(args);
	}
}
