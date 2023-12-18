package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope(value = "Prototype")
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
//    @Autowired
//    private UserService userService;

    @Autowired
//    @Qualifier(value="product")
    private Product product;

    @Autowired
    @Qualifier(value="product2")
    private Product productWithValues;

    public void getAllProducts() {

    }

    public void getProductById(){

    }

    public void printLogForUser() {
        LOGGER.info("U product objektu je: {}", product);
        LOGGER.info("U product sa vrijednostima je: {}", productWithValues);
    }
}
