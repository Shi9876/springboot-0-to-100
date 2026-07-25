package com.learn.springboot.dev.module1Introduction;

import com.learn.springboot.dev.module1Introduction.impl.EmailNotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
	NotificationService notificationServiceObj = new EmailNotificationService();//EmailNotificationService sending the message
	    //NotificationService is an interface so either we can use any implementation class or an anonymous class as suggesting
		// And we can use the name of interface where we use the name of the class which is implementing that interface
		notificationServiceObj.send("hello");
		//Here is tight coupling happening - Module1IntroductionApplication class tightly depend on Notification Service you want to use
		//Next time if want to change the NotificationService then need to come here and change the code here - which we don't want
		//We want to changee the type of notification service that we want to use dynamically
		//Our Module1IntroductionApplication is tightly dependent on NotificationService notificationServiceObj - don't want

	}
}