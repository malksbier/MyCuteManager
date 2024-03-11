package de.springwegarche.MyCuteManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.springwegarche.MyCuteManager.Models.Rule;
import de.springwegarche.MyCuteManager.Models.Topic;
import de.springwegarche.MyCuteManager.Models.DAO.WebTopic;
import de.springwegarche.MyCuteManager.Repository.RuleRepository;
import de.springwegarche.MyCuteManager.Repository.TopicRepository;

@Service
public class RuleService {
    private static String TAG = "[RulesService] ";

    @Autowired
    private RuleRepository ruleRepository;

    public Rule addRule(Rule r) {
        if(r != null) {
            return ruleRepository.save(r);
        } else {
            return new Rule();
        }
    }

    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }

    public void deleteById(long ruleId) {
        ruleRepository.deleteById(ruleId);
    }
}
