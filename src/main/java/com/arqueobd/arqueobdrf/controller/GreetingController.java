package com.arqueobd.arqueobdrf.controller;

import com.arqueobd.arqueobdrf.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting helloWorld(@RequestParam(value="name", defaultValue="World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

}
