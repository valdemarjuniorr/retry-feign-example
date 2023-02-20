package br.com.valdemarjr.retryfeignexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RetryFeignExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryFeignExampleApplication.class, args);
	}

}
