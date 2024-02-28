package de.springwegarche.MyCuteManager.OtherComponents.Mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Models.DAO.TopicState;
import de.springwegarche.MyCuteManager.Service.TopicService;

@Component
public class MqttStateUpdater {
    private static String TAG = "[MqttStateUpdater] ";

    @Autowired
    @Lazy
    MqttManager manager;

    @Autowired
    TopicService topicService;

    public void update(TopicState state) {
        MqttClient client = manager.getMqttClient();

        Topic t = topicService.findById(state.getId()); 

        String topic = "";
        while (t.getParentId() != 0) {
            topic = t.getName() + "/" + topic; 

            t = topicService.findById(t.getParentId()); 
        }
        topic = t.getName() + "/" + topic; 
        topic = topic.substring(0, topic.length()-1);

        
        
        try {
            client.publish(topic, new MqttMessage(state.getState().getBytes()));
        } catch (MqttException e) {
            e.printStackTrace();
        } finally {
            System.out.println(TAG + topic + " set to: " + state.getState());
        }
    }
}
