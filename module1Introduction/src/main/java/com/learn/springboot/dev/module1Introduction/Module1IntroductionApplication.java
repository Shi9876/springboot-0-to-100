package com.learn.springboot.dev.module1Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	@Autowired
	PaymentService paymentServiceObj = null;

	@Autowired
	PaymentService paymentServiceObj1 = null;

	@Autowired
	PaymentService paymentServiceObj2 = null;


	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);
		//PaymentService paymentServiceObj = new PaymentService(); //creating instance of PaymentService class
		//PaymentService paymentServiceObj = null;
		//gave us null pointer exception
		//paymentServiceObj.pay(); //calling method by object
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(paymentServiceObj1.hashCode());
		System.out.println(paymentServiceObj2.hashCode());
		paymentServiceObj.pay();
		paymentServiceObj1.pay();
		paymentServiceObj2.pay();
	}
}

//Note: What happen - via DI the bean that is being managed by spring boot framework will be injected here only
