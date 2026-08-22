package com.learn.springboot.dev.module1Introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay(){
        System.out.println("Paying...");
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Before Paying.");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("After payment is done");
    }
}

//Note - 1.
// If we don't want to manage this class ourselves, we want this to be managed by spring framework only
// so we create a bean of it
//To signify that or tell that we have a annotation called @Component
//When we run our application first "Before Paying" printing then "Paying".This is because just after our bean constructed this afterInt() invoked.
//Then only our main method will invoked - the run() method - as we know run() would only be called once you have all the bean initialised.
//Tomcat server and everything is running then only run() will be invoked