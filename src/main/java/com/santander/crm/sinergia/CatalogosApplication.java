package com.santander.crm.sinergia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CatalogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogosApplication.class, args);
	}
}
