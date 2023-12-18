package com.logate.academy.zima23.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(value="Zima23Application.class")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void kreiranjeObjekataUSpringCont () {
        userService.printLogForUser();
    }

}