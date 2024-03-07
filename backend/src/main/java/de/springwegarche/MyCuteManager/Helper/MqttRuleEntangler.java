package de.springwegarche.MyCuteManager.Helper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.springwegarche.MyCuteManager.Models.Rule;
import de.springwegarche.MyCuteManager.Service.TopicService;

@Component
public class MqttRuleEntangler {
    private static String TAG = "[MqttTopicEntangler] ";

    @Autowired
    private TopicService topicService;

    public boolean validate(Rule r) {
        boolean result = false;
        String reason = "";

        if(r.getName() == "" || r.getRule() == "") {
            result = false;
        } else {
            String rule = r.getRule();
            String[] components = rule.split(" ");
            /*
            for (int i = 0; i < components.length; i++) {
                System.out.println(components[i]); 
            }
             */
            if(components[0].strip().equalsIgnoreCase("TIMER")) { 
                long id  = Long.parseLong((String)components[1].subSequence(1, components[1].length()-1));
                if(topicService.findById(id) != null) {
                    if(components[3].equals("-")) {
                        if(components[2].contains(":") && components[4].contains(":") && components[2].length() == 5 && components[4].length() == 5) {
                            System.out.println(TAG + "'" + rule + "'" + " is a valid TIMER rule"); 
                            return true;
                        }else {
                            reason = "timing wrong";
                        }
                    }else {
                        reason = "schedule wrong";
                    }
                } else {
                    reason = "didnt find topic";
                }
            } else {
                reason = "no matching rule categorie";
            }
        }
        System.out.println(TAG + "'" + r.getRule() + "'" + " is a invalid. reason: " + reason); 
        return result;
    }
}
