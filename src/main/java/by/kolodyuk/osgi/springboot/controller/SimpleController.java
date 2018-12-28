package by.kolodyuk.osgi.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SimpleController {
    @GetMapping("/simple")
    public String index() {
        return "some text";
    }
}
