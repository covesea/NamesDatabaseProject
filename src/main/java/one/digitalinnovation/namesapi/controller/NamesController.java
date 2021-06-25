package one.digitalinnovation.namesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class NamesController {

    @GetMapping
    public String logBook() {
        return "API Test!";
    }
}
