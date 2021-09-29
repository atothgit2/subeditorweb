package com.arpi.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController     // creates an instance
public class TopicController {

    // TopicService is a singleton.
    // If I need the instance that Spring created, I need to ask for it (aka declare dependency):
    @Autowired // Marks that this is something that needs to be (dependency injected.
    private TopicService topicService;

    // Controllers are simple JAVA classes that map a URI and HTTP method to some functionality (Java method).
    // Spring MVC convert response to the right format

    // GET
    @RequestMapping("/topics")
    // Will be automatically converted into JSON
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
        // TopicService will be created only one time in TopicController
    }

    // GET
    @RequestMapping("/topics/{id}")  // {id} = token (variable portion of the path)
    public Topic getTopic(@PathVariable String id) {   // annotation tells Spring that {id} is a variable in the path (maps it to the {id } above
        return topicService.getTopic(id);
    }

    // GET
    @RequestMapping(method = RequestMethod.POST, value = "/topics")  // Map this request to any requests that is a POST on /topics
    public void addTopic(@RequestBody Topic topic) { // annotation tells Spring to pick this instance from the request body
    // This tells Spring that request payload will contain a JSON representation of this Topic instance.
    // It is asked to take this request body convert into a Topic instance and pass it to the addTopic.
        topicService.addTopic(topic);
    }

    // PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}