package com.meek.donald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.meek.donald.employee")
//@ComponentScan(basePackages = {"com.meek.donald.employee", "com.meek.donald"})
//@EntityScan("com.meek.donald")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
