package de.springwegarche.MyCuteManager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Repository.TopicRepository;

@Service
public class TopicService {
    private static String TAG = "[TopicService] ";


    @Autowired
    private TopicRepository topicRepository;

    public Topic addTopic(Topic t) {
        return topicRepository.save(t);
    }
    public Topic addIfNotExistOrReturnTopicByNameAndParentId(Topic t) {
        Optional<Topic> topic = topicRepository.findByNameAndParentId(t.getName(),t.getParentId());
        if(topic.isPresent()) {
            System.out.println(TAG + "Topic: " + t.getName() + " with ParentId: " + t.getParentId() + " loaded");
            return topic.get();
        } else {
            Topic saved = topicRepository.save(t);
            System.out.println(TAG + "Topic: " + t.getName() + " with ParentId: " + t.getParentId() + " saved");
            return saved;
        }
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
    public Topic findById(long id) {
        return topicRepository.getReferenceById(id);
    }
}
