package com.example.ssiach2ex1.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("")
public class HelloController {





//    @GetMapping(value="/hello")
//    public String hello(){
//        return "Hello World" ;
//    }
    @GetMapping(value = "hello-world")
    public String hello(){
        return "hello-world" ;
    }
}
