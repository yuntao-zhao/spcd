package com.spcd.message;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MessageStartup extends SpringBootServletInitializer{

	public static void main(String[] args) {
		new SpringApplicationBuilder(MessageStartup.class).run(args);
	}
}