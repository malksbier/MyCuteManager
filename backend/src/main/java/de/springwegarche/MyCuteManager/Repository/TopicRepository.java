package de.springwegarche.MyCuteManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.springwegarche.MyCuteManager.Models.Topic;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface TopicRepository extends JpaRepository<Topic, Long>{

    //@Query("select t from topics u where t.name = :#{#topic.name} AND t.parent_id = :#{#topic.parentId}")
    Optional<Topic> findByNameAndParentId(String name, long parentId);

    @Modifying
    @Transactional
    @Query("UPDATE Topic t SET t.givenName = :newName WHERE  t.id = :id")
    int updateGivenName(long id, String newName);


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
