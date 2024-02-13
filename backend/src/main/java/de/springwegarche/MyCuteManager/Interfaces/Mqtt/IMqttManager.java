package de.springwegarche.MyCuteManager.Interfaces.Mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;

public interface IMqttManager {
    public String test();
    public MqttClient getMqttClient();
}
