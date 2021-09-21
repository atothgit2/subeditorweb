package com.arpi.subeditorweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubEditorController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name;
    }
}
