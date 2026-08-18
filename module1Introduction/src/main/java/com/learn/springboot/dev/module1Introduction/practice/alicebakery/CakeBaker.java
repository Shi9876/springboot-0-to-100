package com.learn.springboot.dev.module1Introduction.practice.alicebakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * ====================== CAKE BAKER - DI NOTES ======================
 *
 * PURPOSE:
 * CakeBaker depends on two things:
 *      1. Frosting
 *      2. Syrup
 *
 * These dependencies are provided by Spring using Dependency Injection.
 *
 *
 * 1. DEPENDENCY DECLARATION
 *
 * private final Frosting frosting;
 * private final Syrup syrup;
 *
 * Frosting and Syrup → Interfaces / Types
 * frosting and syrup → Reference variables
 *
 * At this point, no object is created here.
 *
 *
 * 2. CONSTRUCTOR INJECTION
 *
 * Spring provides the required bean objects through the constructor:
 *
 * public CakeBaker(
 *     @Qualifier("chocolateFrosting") Frosting frosting,
 *     @Qualifier("chocolateSyrup") Syrup syrup)
 *
 * This is called CONSTRUCTOR INJECTION.
 *
 *
 * 3. WHY @QUALIFIER?
 *
 * There are multiple implementations of the same interface:
 *
 * Frosting
 *    ├── ChocolateFrosting
 *    └── StrawberryFrosting
 *
 * Syrup
 *    ├── ChocolateSyrup
 *    └── StrawberrySyrup
 *
 * Spring cannot decide which implementation to inject automatically.
 *
 * @Qualifier("chocolateFrosting")
 *        ↓
 * Tells Spring to inject the bean named "chocolateFrosting".
 *
 * @Qualifier("chocolateSyrup")
 *        ↓
 * Tells Spring to inject the bean named "chocolateSyrup".
 *
 *
 * 4. CLASS vs BEAN NAME vs OBJECT
 *
 * ChocolateFrosting
 *        ↓
 *      CLASS
 *
 * "chocolateFrosting"
 *        ↓
 *    BEAN NAME
 *
 * new ChocolateFrosting()
 *        ↓
 *   ACTUAL OBJECT
 *
 * Spring creates the actual object during application startup.
 *
 *
 * 5. HOW SPRING DOES IT (CONCEPTUALLY)
 *
 * Application starts
 *        ↓
 * Spring scans @Component
 *        ↓
 * Finds ChocolateFrosting and ChocolateSyrup
 *        ↓
 * Spring creates their objects
 *        ↓
 * Stores them as Spring Beans
 *        ↓
 * CakeBaker is created
 *        ↓
 * @Qualifier identifies the required beans
 *        ↓
 * Actual bean objects are passed to the CakeBaker constructor
 *        ↓
 * this.frosting = frosting
 * this.syrup = syrup
 *
 *
 * 6. IMPORTANT
 *
 * We do NOT manually write:
 *
 * new ChocolateFrosting()
 * new ChocolateSyrup()
 *
 * Spring creates and manages these objects for us.
 *
 * This is the main idea of INVERSION OF CONTROL (IoC) and
 * DEPENDENCY INJECTION (DI).
 *
 * ====================================================================
 */


@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    //Constructor Injection
    public CakeBaker(@Qualifier("chocolateFrosting") Frosting frosting, @Qualifier("chocolateSyrup") Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }
    public void bakeCake(){
        System.out.println("Baking Cake...");
        System.out.println("Frosting: "+frosting.getFrostingType());//get the type from the injected frosting object
        System.out.println("Syrup: "+syrup.getSyrupType());
        System.out.println("Cake is ready!");
    }
}


//frosting and syrup are reference variables (fields) inside CakeBaker
//CakeBaker has a place/reference where a frosting object and a syrup object will be stored
//At this point, nothing has been injected yet