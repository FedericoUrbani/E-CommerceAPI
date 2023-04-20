package it.develhope.shoppyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class ShoppyzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppyzApplication.class, args);
    }

}