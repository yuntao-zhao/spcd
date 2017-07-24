package com.christy.spcd.mobile;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.christy.spcd.wsapi")
@ComponentScan("com.christy.spcd")
public class AppConfig {

}
