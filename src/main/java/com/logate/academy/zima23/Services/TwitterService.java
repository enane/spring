package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.Configurations.TwitterAPIConfiguration;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

    private static Logger LOGGER = LoggerFactory.getLogger(TwitterService.class);

//    @Value("${twitter-api.base-url}")
//    String baseUrl;
//
//    @Value("${twitter-api.auth-token}")
//    String authToken;
//
//    @Value("${twitter-api.port}")
//    int port;

    @Autowired
    private TwitterAPIConfiguration twitterAPIConfiguration;

    @Autowired
    Environment environment;

//    public void configValue() {
//        LOGGER.info("Twitter config base url: {}", baseUrl);
//        LOGGER.info("Twitter config auth token: {}", authToken);
//        LOGGER.info("Twitter config port: {}", port);
//    }

    public void configFromConfigClass() {
        LOGGER.info("Twitter config is: {}", twitterAPIConfiguration);
        LOGGER.info("Twitter config user-name is: {}", twitterAPIConfiguration.getUserName());
    }

    public void configFromEnviroment() {
        Integer port = environment.getProperty("twitter-api.port", Integer.class);
        String baseUrl = environment.getProperty("twitter-api.base-url");
        String userName = environment.getProperty("twitter-api.user","mmarkovic");
        String authToken =environment.getRequiredProperty("twitter-api.nesto");

        LOGGER.info("Twitter config port: {}", port);
        LOGGER.info("Twitter config baseUrl: {}", baseUrl);
        LOGGER.info("Twitter config userName: {}", userName);
    }
}
