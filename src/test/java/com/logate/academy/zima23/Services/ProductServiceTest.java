package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(value = "Zima23Application.class")
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void kreiranjeObjekataUSpringCont () {
        productService.printLogForUser();
    }

}