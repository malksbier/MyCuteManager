package de.springwegarche.MyCuteManager.Helper;

import java.util.ArrayList;

import de.springwegarche.MyCuteManager.Models.SimpleTopic;
import de.springwegarche.MyCuteManager.Models.Topic;

public class MqttTopicEntangler {
    private static String TAG = "[MqttTopicEntangler] ";

    private static String infoFlag = "/info";

    public static ArrayList<Topic> entangleTopics(ArrayList<SimpleTopic> longTopics) {
        // remove all non info Topics;
        for(int i = 0;i<longTopics.size();i++) {
            if(! longTopics.get(i).getTopic().endsWith(infoFlag))  {
                longTopics.remove(i);
                i--;
            }
        }
        System.out.println(TAG + "found " + longTopics.size() + "valid Topics");
        
        for(int i = 0;i<longTopics.size();i++) {

        }

        Topic main = Topic.createTopicForNormalizing("malksbier", null, null);
        Topic sub1 = Topic.createTopicForNormalizing("hof", main , "An/aus");
        Topic sub2 = Topic.createTopicForNormalizing("haus", main , "An/aus");

        /* 
        Topic main = new Topic("malksbier", "", null);
        main.getChildren().add(new Topic("Haus", "", main));
        main.getChildren().add(new Topic("Hof", "", main));
        */
        
        ArrayList<Topic> result = new ArrayList<Topic>();
        

        result.add(main);
        result.add(sub1);
        result.add(sub2);
        return result;
    }
}
