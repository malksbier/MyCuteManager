package de.springwegarche.MyCuteManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.springwegarche.MyCuteManager.Helper.MqttTopicEntangler;
import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Models.DAO.TopicState;
import de.springwegarche.MyCuteManager.Models.DAO.WebTopic;
import de.springwegarche.MyCuteManager.OtherComponents.Mqtt.MqttStateUpdater;
import de.springwegarche.MyCuteManager.Service.TopicService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MqttController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private MqttStateUpdater mqttStateUpdater;

    @GetMapping({"/mqtt/getAllTopics"})
    public List<WebTopic> getAllTopics() {
        return MqttTopicEntangler.morphToWebTopics(topicService.findAll());
    }

    @PostMapping({"/mqtt/setTopicState"})
    public ResponseEntity<String> setTopicState(@RequestBody TopicState state) {
        
        mqttStateUpdater.update(state);

        return new ResponseEntity<>(
            "test", 
            HttpStatus.OK);
    }
}
