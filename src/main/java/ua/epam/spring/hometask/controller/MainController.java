package ua.epam.spring.hometask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@Controller
public class MainController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

}
