package com.logate.academy.zima23.Configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twitter-api")
public class TwitterAPIConfiguration {

//    twitter-api:
//    base-url: "https://192.178.68.12/api/twitter"
//    auth-token: "jsibq1@!"
//    port: 4444
//    user-name: "sradenovic"

    String baseUrl; //base-url | base_url

    String authToken;
    int port;
    String userName;

    Double price;

    @Override
    public String toString() {
        return "TwitterAPIConfiguration{" +
                "baseUrl='" + baseUrl + '\'' +
                ", authToken='" + authToken + '\'' +
                ", port=" + port +
                ", userName='" + userName + '\'' +
                ", price=" + price +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
