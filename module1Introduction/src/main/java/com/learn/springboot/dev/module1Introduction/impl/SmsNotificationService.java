package com.learn.springboot.dev.module1Introduction.impl;

import com.learn.springboot.dev.module1Introduction.NotificationService;

public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sms sending..."+message);
    }
}
