package it.develhope.shoppyz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Shoppyz")
public class WelcomeController {

    @GetMapping
    public String welcomePage(){
        return "Welcome in shoppyz!\n" +
                "\n" +
                "Use the following Api Endpoints\n" +
                "\n" +
                "http://localhost:8080/Shoppyz/account";
    }
}
