package com.learn.springboot.dev.module1Introduction.practice.alicebakery;

import org.springframework.stereotype.Component;

@Component
public class ChocolateSyrup implements Syrup{

    public String getSyrupType(){
        return "Chocolate";
    }
}
