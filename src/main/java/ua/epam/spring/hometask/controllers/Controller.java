package ua.epam.spring.hometask.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
