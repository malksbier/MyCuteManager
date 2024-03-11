package de.springwegarche.MyCuteManager.Controller;

import java.util.ArrayList;
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

import de.springwegarche.MyCuteManager.Helper.MqttRuleEntangler;
import de.springwegarche.MyCuteManager.Helper.MqttTopicEntangler;
import de.springwegarche.MyCuteManager.Models.Rule;
import de.springwegarche.MyCuteManager.Models.DAO.DeleteRequest;
import de.springwegarche.MyCuteManager.Models.DAO.TopicNewName;
import de.springwegarche.MyCuteManager.Models.DAO.TopicState;
import de.springwegarche.MyCuteManager.Models.DAO.WebRule;
import de.springwegarche.MyCuteManager.Models.DAO.WebTopic;
import de.springwegarche.MyCuteManager.OtherComponents.Mqtt.MqttStateUpdater;
import de.springwegarche.MyCuteManager.Service.RuleService;
import de.springwegarche.MyCuteManager.Service.TopicService;

@CrossOrigin(origins = "*")
@RestController
public class MqttRuleController {
    private static String TAG = "[MqttRuleController] ";

    @Autowired
    private RuleService ruleService;
    @Autowired
    private MqttRuleEntangler mqttRuleEntangler;

    @GetMapping({"/mqtt/getAllRules"})
    public List<WebRule> getAllTopics() {
        List<Rule> rules = ruleService.findAll();
        ArrayList<WebRule> webRules = new ArrayList<>();

        // add parent nodes
        for (int i = 0; i < rules.size(); i++) {
            webRules.add(WebRule.fromRule(rules.get(i)));
        }
        return webRules;
    }

    @PostMapping({"/mqtt/writeNewRule"})
    public ResponseEntity<?> writeNewRule(@RequestBody Rule rule) {
        if(mqttRuleEntangler.validate(rule)) {

            Rule newRule = ruleService.addRule(rule);
            return new ResponseEntity<WebRule>(WebRule.fromRule(newRule), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping({"/mqtt/deleteRule"})
    public ResponseEntity<?> deleteRule(@RequestBody DeleteRequest request) {
        ruleService.deleteById(request.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
