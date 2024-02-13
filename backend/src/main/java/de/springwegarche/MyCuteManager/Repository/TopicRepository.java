package de.springwegarche.MyCuteManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import de.springwegarche.MyCuteManager.Models.Topic;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface TopicRepository extends JpaRepository<Topic, Long>{
    /*
    Optional<Topic> findById(long id);

    Topic save(Topic person);
    /*
     @Modifying
    @Transactional
    
    @Query("select t from Topic t")
    List<Topic> findAll();
    */
   
}
