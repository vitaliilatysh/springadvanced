package ua.epam.spring.hometask.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Latysh
 * Created: 10.03.2020
 */
@RestController
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

}
