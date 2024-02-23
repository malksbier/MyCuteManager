package de.springwegarche.MyCuteManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import de.springwegarche.MyCuteManager.Helper.ConsolePicturePrinter;
import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.OtherComponents.Mqtt.MqttManager;
import de.springwegarche.MyCuteManager.Service.TopicService;

@SpringBootApplication
public class MyCuteManagerApplication {
	private static String TAG = "[MyCuteManagerApplication] ";

	MqttManager mqttManager; 

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyCuteManagerApplication.class, args);

		ConsolePicturePrinter.printLogo();

		MqttManager mqttManager = context.getBean(MqttManager.class);
		mqttManager.start();
	}

	

	MyCuteManagerApplication() {
		

		/* 
		topicService.addTopic(new Topic("test", "test1"));
		topicService.addTopic(new Topic("test2", "test1"));
		topicService.addTopic(new Topic("test3", "test1"));
		topicService.addTopic(new Topic("test4", "test1"));
		topicService.addTopic(new Topic("test5", "test1"));
		topicService.addTopic(new Topic("test6", "test1"));
		*/
	}

	

}
