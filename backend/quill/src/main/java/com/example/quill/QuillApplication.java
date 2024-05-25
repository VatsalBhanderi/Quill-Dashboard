package com.example.quill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.example.quilllite.repository")
@PropertySource("classpath:application.properties")
public class QuillApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuillApplication.class, args);
	}

}
