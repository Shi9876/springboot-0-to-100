package com.learn.springboot.dev.module1Introduction.impl;

import com.learn.springboot.dev.module1Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("emailNotif")
//@ConditionalOnProperty(name = "notification.type", havingValue = "email" )
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Email sending..."+message);
    }
}

//Note: @ConditionalOnProperty() -
//Only when the notification.type property has the value of email in that case we should only create the bean of this particular class.
//Else no need to create the bean of this particular class.
//What we have achieved here using this - we get the rif from qualifier form
// Ex: public Module1IntroductionApplication( @Qualifier("smsNotif") NotificationService notificationServiceObj){
// this.notificationServiceObj = notificationServiceObj;
// }

//application.properties -
//notification.type = email - we are getting email only not sms
//As we have defined notification.type as email so only EmailNotificationBean is created, SMSNotificationBean would not even be created.

