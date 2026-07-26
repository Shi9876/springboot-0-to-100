package com.learn.springboot.dev.module1Introduction;

import com.learn.springboot.dev.module1Introduction.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	@Autowired
	NotificationService notificationServiceObj;//field dependency injection as field getting injected by itself

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
	//notificationServiceObj = new EmailNotificationService();
	  notificationServiceObj.send("hello");
	}
}