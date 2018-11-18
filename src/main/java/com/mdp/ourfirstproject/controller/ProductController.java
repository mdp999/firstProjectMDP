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

    @RequestMapping("/")
    public String create()
    {
        return "Hello world";
    }

    @RequestMapping("/")
    public String read()
    {
        return "Hello world";
    }

    @RequestMapping("/")
    public String update()
    {
        return "Hello world";
    }

    @RequestMapping("/")
    public String delete()
    {
        return "Hello world";
    }

}
