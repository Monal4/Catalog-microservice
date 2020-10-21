package com.music.CatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication(scanBasePackages = { "com.music.CatalogService" })
@EnableDiscoveryClient
public class CatalogServiceApplication {
	
//	@Autowired
//	private ConfigurableEnvironment env;
//		
//	env.setDefaultProfiles("integrationtest");
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
