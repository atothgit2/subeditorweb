package com.arpi.springbootstarter.topic;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// In Spring services are typically singletons.
// When the app starts up Spring creates a single instance and keeps it in memory.
// Spring will know that this is a service and will inject it to different classes.
@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("spring", "Spring Framework", "Spring Framework Description"),
        new Topic("java", "Core Java", "Core Java Description"),
        new Topic("javascript", "JavaScript", "JavaScript Description")
        ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    // Accessing single element from topics
    public Topic getTopic(String id) {
        // A more fancy way to iterate over elements and select first
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); // Filter lambda expression
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i <  topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}

