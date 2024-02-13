package de.springwegarche.MyCuteManager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {
    @GetMapping({"/mqtt/getAllTopics"})
    public String getAllTopics() {
        return "Hello";
    }
}
