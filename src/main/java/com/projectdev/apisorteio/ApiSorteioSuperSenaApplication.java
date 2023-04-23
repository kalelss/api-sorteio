package com.projectdev.apisorteio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiSorteioSuperSenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSorteioSuperSenaApplication.class, args);
	}

}
