package com.arpi.springbootstarter.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    // Controllers are simple JAVA classes that map a URI and HTTP method to some functionality (Java method).
    // Spring MVC convert response to the right format

    @RequestMapping("/topics")
    // Will be automatically converted into JSON
    public List<Topic> getAllTopics() {
        return Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")
        );
   }
}
