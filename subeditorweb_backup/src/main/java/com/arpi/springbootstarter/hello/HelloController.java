package com.arpi.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping("/hello")
        // When there is a request to the application with /hello...
        // ...we want this method (below) run.

        // Since there is no HTTP method, by default, @RequestMapping only maps a GET method.
        // Any other HTTP method should be specified by annotation.
    public String sayHi() {
        return "Hi!";
    }
}
