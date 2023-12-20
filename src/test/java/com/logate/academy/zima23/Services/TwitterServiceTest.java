package com.logate.academy.zima23.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(value="Zima23Application.class")
@ActiveProfiles(profiles = "prod")
class TwitterServiceTest {

    @Autowired
    private TwitterService twitterService;

//    @Test
//    public void printingValuesFromTwitterConfig() {
//        twitterService.configValue();
//    }

    @Test
    public void printingValuesFromTwitterConfigWithClass() {
        twitterService.configFromConfigClass();
    }


    @Test
    public void printingValuesFromTwitterConfigWithEnv() {
        twitterService.configFromEnviroment();
    }
}