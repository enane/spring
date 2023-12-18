package com.logate.academy.zima23.Configurations;

import com.logate.academy.zima23.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean(name="product")
    public Product markoMarkovic() {
        return new Product();
    }

    @Bean(name="product2")
    public Product jankoJankovic() {
        return new Product(1, "Samsung 55'", "Televizor", 500.39);
    }
}
