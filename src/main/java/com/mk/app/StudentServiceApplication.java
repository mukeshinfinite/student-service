package com.mk.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.mk.controller", "com.mk.service"})
@EntityScan("com.mk.entity")
@EnableJpaRepositories("com.mk.repository")
@EnableFeignClients("com.mk.feignclients")
@EnableDiscoveryClient
//@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class StudentServiceApplication {

//	@Value("${address.service.url}")
//	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}


//	@Bean
//	public WebClient webClient(){
//
//		WebClient webClient = WebClient.builder()
//				.baseUrl(addressServiceUrl).build();
//		return webClient;
//	}


}
