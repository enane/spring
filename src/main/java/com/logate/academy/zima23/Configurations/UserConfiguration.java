package com.logate.academy.zima23.Configurations;

import com.logate.academy.zima23.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {


    @Bean
    public User user () {
        User user = new User(1,"Stefan Radenovic", 31);
        return user;
    }

   @Bean(name="userMarko")
    public User user2 () {
        User user = new User(2,"Marko Markovic", 21);
        return user;
    }
}
