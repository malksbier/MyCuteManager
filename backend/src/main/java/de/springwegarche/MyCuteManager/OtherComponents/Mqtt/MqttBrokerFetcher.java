package de.springwegarche.MyCuteManager.OtherComponents.Mqtt;
/*
Purpose of this class is to update the Database based on all topics that exist on a Broker and sort them into a DB
 */

import java.util.ArrayList;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import de.springwegarche.MyCuteManager.Helper.MqttTopicEntangler;
import de.springwegarche.MyCuteManager.Interfaces.Mqtt.IMqttBrokerFetcher;
import de.springwegarche.MyCuteManager.Models.SimpleTopic;
import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Service.TopicService;

@Component
public class MqttBrokerFetcher extends Thread implements IMqttBrokerFetcher{
    private static String TAG = "[MqttBrokerFetcher] ";

    @Autowired
    @Lazy
    MqttManager manager;

    @Autowired
    TopicService topicService;

    private MqttClient mqttClient;
    private ArrayList<SimpleTopic> collectedSimpleTopics;

    
    public MqttBrokerFetcher() {
        System.out.println(TAG + "started");

        collectedSimpleTopics = new ArrayList<>();
    };

    private void update() {
        // clear last round

        collectedSimpleTopics.clear();

        // GET TOPICS
        this.mqttClient = manager.getMqttClient();
        while (!mqttClient.isConnected()) {
            try {
                System.out.println(TAG + "waiting for Broker Connection");
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(TAG+ "EXCEPTION while connectiong to Broker");
                e.printStackTrace();
            }
        }

        System.out.println(TAG + "subscribing");

        try {
            mqttClient.subscribe("#", (topic, msg) -> {
                readMessageAllRatained(topic,msg);
            });

            Thread.sleep(2000);
        } catch (MqttException | InterruptedException e) {
            System.out.println(TAG+ "EXCEPTION while reading incomming Message");
            e.printStackTrace();
        }    

        try {
            System.out.println(TAG + "unsubscribing");
            mqttClient.unsubscribe("#");
        } catch (MqttException e) {
            System.out.println(TAG+ "EXCEPTION while unsubscribing");
            e.printStackTrace();
        }

        System.out.println(TAG + "found " + collectedSimpleTopics.size() + " Topics");
        ArrayList<Topic> normalizedTopics = MqttTopicEntangler.entangleTopics(collectedSimpleTopics);

        for(int i = 0;i<normalizedTopics.size();i++) {
            topicService.addTopic(normalizedTopics.get(i));
        }

        

    }

    private void readMessageAllRatained(String topic, MqttMessage message) {
        //System.out.println(TAG + "recieved message: " + topic + ": " + message.toString());
        collectedSimpleTopics.add(new SimpleTopic(topic, message.toString()));
    }

    @Override
    public void run() {
        System.out.println(TAG + "run");

        update();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(TAG+ "EXCEPTION while run() sleep");
            e.printStackTrace();
        }
    }
}
