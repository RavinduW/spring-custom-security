package com.wdr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class IndexController {

    @GetMapping("/all")
    public String hello(){
        return "all index";
    }

    @GetMapping("/secured/all")
    public String securedHello(){
        return "secured index";
    }

    @GetMapping("/user/all")
    public String userIndex(){
        return "normal user index";
    }

}
