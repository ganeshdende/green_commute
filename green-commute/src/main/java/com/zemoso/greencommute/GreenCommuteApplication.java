package com.zemoso.greencommute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreenCommuteApplication {

	public static  void main(String[] args) {

		SpringApplication.run(GreenCommuteApplication.class);
	}

}
//./mvnw verify sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.organization=ganeshdende -Dsonar.login=51c3738f43962dac8595df6385018f19e2ae2b08 -Dsonar.projectKey=ganeshdende_green_commute

