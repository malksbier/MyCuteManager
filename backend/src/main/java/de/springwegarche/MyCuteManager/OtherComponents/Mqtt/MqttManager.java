package de.springwegarche.MyCuteManager.OtherComponents.Mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import de.springwegarche.MyCuteManager.Interfaces.Mqtt.IMqttManager;
/* 
ROOT for all MQTT things

based on:
https://www.baeldung.com/java-mqtt-client
*/
@Component
@ConfigurationProperties("mqtt")
public class MqttManager extends Thread implements IMqttManager  {

    
    @Autowired
    private MqttBrokerFetcher brokerFetcher;

    private String mqttBorkerAdress = "tcp://192.168.2.127:1883";
    //private String mqttBorkerAdress = "tcp://iot.eclipse.org:1883";
    private String mqttClientName = "MyCuteManager";

    private MqttClient mqttClient;

    private static String TAG = "[MqttManager] ";
    public MqttManager() {
        System.out.println(TAG + "started");

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);

        try {
            mqttClient = new MqttClient(mqttBorkerAdress, mqttClientName);
            mqttClient.connect(options);
        } catch (MqttException e) {
            System.out.println(TAG+ "EXCEPTION");
            e.printStackTrace();
        }
    };

    @Override
    public MqttClient getMqttClient() {
        return mqttClient;
    }

    @Override
    public String test() {
        return "test";
    }

    @Override
    public void run() {
        System.out.println(TAG + "run");
        brokerFetcher.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(TAG+ "EXCEPTION");
            e.printStackTrace();
        }
    }
}
