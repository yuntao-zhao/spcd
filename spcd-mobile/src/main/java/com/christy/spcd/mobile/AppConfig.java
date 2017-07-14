package com.christy.spcd.mobile;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages={"com.christy.spcd.wsapi"})
public class AppConfig {

}
