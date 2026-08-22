package com.learn.springboot.dev.module1Introduction;

import com.learn.springboot.dev.module1Introduction.impl.EmailNotificationService;
import com.learn.springboot.dev.module1Introduction.practice.alicebakery.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


/*
 * ======================= MODULE 1 PRACTICE NOTES =======================
 *
 * This application contains two practice examples:
 *
 * 1. NotificationService - Map Injection
 *    Spring injects all implementations of NotificationService
 *    into Map<String, NotificationService>.
 *
 *    Key   → Bean name
 *    Value → Actual bean object
 *
 *
 * 2. Alice Bakery - Dependency Injection
 *    CakeBaker depends on Frosting and Syrup.
 *    Spring creates the required bean objects and injects them
 *    into CakeBaker through constructor injection.
 *
 *    @Qualifier is used because multiple implementations exist.
 *
 *    @Qualifier("chocolateFrosting")
 *    → selects the ChocolateFrosting bean.
 *
 *    @Qualifier("chocolateSyrup")
 *    → selects the ChocolateSyrup bean.
 *
 *    The CakeBaker object is injected into this application,
 *    and cakeBaker.bakeCake() is called from run().
 *
 * ========================================================================
 */


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

	@Autowired
	CakeBaker cakeBaker;
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

		//Alice Bakery practice task
		cakeBaker.bakeCake();

	}
}

//Note: Why we prefer constructor injection - we can mae field as final that means we cannot change it after initialization
//variables are now immutable so they cannot be modified.