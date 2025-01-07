package com.generalnitin.springaop.controllers;

import com.generalnitin.springaop.services.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping()
    public String hello() {
        return homeService.sayHello();
    }
}
