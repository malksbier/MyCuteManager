package de.springwegarche.MyCuteManager.Helper;

import java.util.ArrayList;
import java.util.List;

import de.springwegarche.MyCuteManager.Models.SimpleTopic;
import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Models.DAO.WebTopic;
import de.springwegarche.MyCuteManager.Service.TopicService;

public class MqttTopicEntangler {
    private static String TAG = "[MqttTopicEntangler] ";

    private static String infoFlag = "/info";
    private static String infoForDirectories = "dir";

    // create WebTopics
    public static ArrayList<WebTopic> morphToWebTopics(List<Topic> topics) {
        ArrayList<WebTopic> result = new ArrayList<>();

        // convert to WebTopics
        for (int i=0; i<topics.size(); i++) {
            result.add(WebTopic.fromTopic(topics.get(i)));
        }
        for (int i=0; i<result.size(); i++) {
            WebTopic t = result.get(i);

            //System.out.println(TAG+ "looking for parent for: " + t.getName());
            if(t.getParentId() != 0) {
                for (int k = 0; k < result.size(); k++) {
                    if(k!=i) {
                        WebTopic possibleParent = result.get(k);

                        if(t.getParentId() == possibleParent.getId()) {
                            possibleParent.addChild(t);
                        }
                    }
                }
            } 
        }


        // remove all non Root Topics
        for (int i=0; i<result.size(); i++) {
            WebTopic t = result.get(i);
            if(t.getParentId() != 0) {
                result.remove(i);
                i--;

                //System.out.println(TAG + t.getName() +  " " +  t.getParentId());
            }
        }


        return result;
    }

    // removes all non info Topics and removes the "info" Topic
    public static ArrayList<SimpleTopic> cleanUpTopics(ArrayList<SimpleTopic> longTopics) {
        // remove all non info Topics;
        for(int i = 0;i<longTopics.size();i++) {
            if(! longTopics.get(i).getTopic().endsWith(infoFlag))  {
                longTopics.remove(i);
                i--;
            }
        }
        System.out.println(TAG + "found " + longTopics.size() + " valid Topics");

        // remove "/info"
        for(int i = 0;i<longTopics.size();i++) {
            SimpleTopic st = longTopics.get(i);
            st.setTopic(st.getTopic().substring(0, st.getTopic().length() - infoFlag.length()));
            longTopics.set(i, st);
        }

        /* 
        for(int i = 0;i<longTopics.size();i++) {
            // splitting SimpleTopics to unique ones
            SimpleTopic st = longTopics.get(i);
            
            System.out.println(st.getTopic());

            String[] singleTopics = st.getTopic().split("/");
            for(int k=0;k< singleTopics.length; k++){
                String topicName = singleTopics[k];
                System.out.print(topicName);

                Topic newTopic;

                if(!result.contains(newTopic)) {
                    result.add(newTopic);
                }
            }
            
        }

        Topic main = Topic.createTopicForNormalizing("malksbier", null, null);
        Topic sub1 = Topic.createTopicForNormalizing("hof", main , "An/aus");
        Topic sub2 = Topic.createTopicForNormalizing("haus", main , "An/aus");

        
        Topic main = new Topic("malksbier", "", null);
        main.getChildren().add(new Topic("Haus", "", main));
        main.getChildren().add(new Topic("Hof", "", main));
        
        
        //ArrayList<Topic> result = new ArrayList<Topic>();
        

        result.add(main);
        result.add(sub1);
        result.add(sub2);
        */
        return longTopics;
    }

    public static void cleanAndWriteToDb(TopicService topicService, ArrayList<SimpleTopic> topicsFromBroker) {
        ArrayList<SimpleTopic> cleanedUpTopics = cleanUpTopics(topicsFromBroker);

        for(int cleandCounter = 0; cleandCounter < cleanedUpTopics.size(); cleandCounter++) {
            SimpleTopic st = cleanedUpTopics.get(cleandCounter);
            //System.out.println(st.toString());
            String[] singleTopics = st.getTopic().split("/");

            Topic parent;
            long lastParent = 0;
            for(int singleTopicCounter = 0; singleTopicCounter < singleTopics.length; singleTopicCounter++) {
                
                Topic t = new Topic(singleTopics[singleTopicCounter]);
                t.setParentId(lastParent);

                // INFO 
                if(singleTopicCounter == singleTopics.length - 1) {
                    t.setInfo(st.getMessage());
                } else {
                    t.setInfo(infoForDirectories);
                }
                
                parent = topicService.addIfNotExistOrReturnTopicByNameAndParentId(t);
                if(parent != null) {
                    lastParent = parent.getId();
                } else {
                    lastParent = -1;
                }
            }
        }
    }
}
