package br.com.test.fakehdi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("br.com.test.fakehdi")
@EntityScan("br.com.test.fakehdi")
@EnableJpaRepositories("br.com.test.fakehdi")
public class InsuranceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceTestApplication.class, args);
	}

}
