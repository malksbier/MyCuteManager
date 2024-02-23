package de.springwegarche.MyCuteManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Service.TopicService;

@RestController
public class MqttController {
    @Autowired
    private TopicService topicService;

    @GetMapping({"/mqtt/getAllTopics"})
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }
}
