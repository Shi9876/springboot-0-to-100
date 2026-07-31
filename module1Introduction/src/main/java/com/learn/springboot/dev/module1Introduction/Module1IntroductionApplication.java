package com.learn.springboot.dev.module1Introduction;

import com.learn.springboot.dev.module1Introduction.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	//@Autowired
//	final NotificationService notificationServiceObj;// dependency injection/// declaring here
//
	/*public Module1IntroductionApplication( @Qualifier("smsNotif") NotificationService notificationServiceObj){
		this.notificationServiceObj = notificationServiceObj; //constructor DI/// Preferred way
	}
	 */
//
//	public Module1IntroductionApplication(NotificationService notificationServiceObj) {
//		this.notificationServiceObj = notificationServiceObj; //constructor DI/// Preferred way
//	}


	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>();//will inject all the implementions of NotificationService

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
//	notificationServiceObj = new EmailNotificationService();
//	  notificationServiceObj.send("hello");
		for(var notificationService: notificationServiceMap.entrySet()){
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello");
		}

	}
}

//Note: Why we prefer constructor injection - we can mae field as final that means we cannot change it after initialization
//variables are now immutable so they cannot be modified.