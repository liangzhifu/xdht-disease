package com.xdht.disease.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.xdht.disease.common","com.xdht.disease.third"})
public class SdhtDiseaseThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdhtDiseaseThirdApplication.class, args);
	}
}
