package com.example.messagingstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessagingstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingstudyApplication.class, args);
	}

}
