package com.mdp.ourfirstproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/")
    public String hello()
    {
        return "Hello world";
    }


}
