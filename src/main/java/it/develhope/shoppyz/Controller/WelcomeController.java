package it.develhope.shoppyz.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class WelcomeController {

    /* Mapping for welcome page */
    @GetMapping("/Shoppyz")
    public String sayHello (Model model){
        /* prima pagina da visualizzare */
        return "index";
    }
}
