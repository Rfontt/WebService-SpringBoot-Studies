package com.rest.webservice.controller;

import com.rest.webservice.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    // GET
    // URI - /hello-world
    // Method - "Hello World"

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }

    // hello-world-bean
    @GetMapping("/bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping("/path-variable/{name}")
    public HelloWorldBean helloWorldParameters(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }
}
