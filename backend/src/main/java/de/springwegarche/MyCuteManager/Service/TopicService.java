package de.springwegarche.MyCuteManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Repository.TopicRepository;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public void addTopic(Topic t) {
        topicRepository.save(t);
    }
    
}
