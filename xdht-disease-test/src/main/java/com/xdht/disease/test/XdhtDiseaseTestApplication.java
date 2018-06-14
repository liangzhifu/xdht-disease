package com.xdht.disease.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan({"com.xdht.disease.common","com.xdht.disease.test"})
public class XdhtDiseaseTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdhtDiseaseTestApplication.class, args);
	}
}
