package de.springwegarche.MyCuteManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.springwegarche.MyCuteManager.Helper.MqttTopicEntangler;
import de.springwegarche.MyCuteManager.Models.Rule;
import de.springwegarche.MyCuteManager.Models.DAO.TopicNewName;
import de.springwegarche.MyCuteManager.Models.DAO.TopicState;
import de.springwegarche.MyCuteManager.Models.DAO.WebTopic;
import de.springwegarche.MyCuteManager.OtherComponents.Mqtt.MqttStateUpdater;
import de.springwegarche.MyCuteManager.Service.RuleService;
import de.springwegarche.MyCuteManager.Service.TopicService;

@CrossOrigin(origins = "*")
@RestController
public class MqttRuleController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private RuleService ruleService;

    @GetMapping({"/mqtt/getAllRules"})
    public List<Rule> getAllTopics() {
        return ruleService.findAll();
    }

}
