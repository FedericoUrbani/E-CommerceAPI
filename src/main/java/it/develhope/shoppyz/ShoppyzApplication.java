package it.develhope.shoppyz;


import it.develhope.shoppyz.account.AccountServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class ShoppyzApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShoppyzApplication.class, args);

    }



}