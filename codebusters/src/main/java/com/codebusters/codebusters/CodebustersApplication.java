package com.codebusters.codebusters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.codebusters.codebusters.models.entities")
public class CodebustersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebustersApplication.class, args);
	}

}
