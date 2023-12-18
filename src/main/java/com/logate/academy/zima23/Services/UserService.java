package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.Repositories.UserRepository;
import com.logate.academy.zima23.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component // | //@Service | //@Repository
//@Controller
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    //UserRepository userRepository;

//   void listAllUser() {
//        userRepository.listAllUser();
//    }

//    void listUserWithId(int id) {
//        userRepository.listUserWithId(int id);
//    }

    //prvi nacin DI
@Autowired
private ProductService productService;

@Autowired
private User user;

@Autowired
// User user2;
@Qualifier(value = "userMarko")
private User user2;

    //drugi nacin DI
//private ProductService productService;

//public void setProductService (ProductService productService) {
//    this.productService = productService;
//}

    //treci nacin DI
//public UserService(ProductService productService) {
//    this.productService = productService;
//}


    @PostConstruct

    @PreDestroy

    public void printLogForUser() {
        LOGGER.info("U user objektu je: {}", user);
        LOGGER.info("U user2 objekty je: {}", user2);
    }

}
