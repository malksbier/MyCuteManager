package de.springwegarche.MyCuteManager.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
@Table(name = "TOPICS", uniqueConstraints = { @UniqueConstraint( columnNames = { "name", "parent_id" } ) })
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "given_name")
    private String givenName = "";
    @Column(name = "info")
    private String info = "";

    @Column(name = "parent_id", columnDefinition = "long default 0")
    private long parentId;

    public Topic(String name) {
        this.name = name;
    }

    // GENERATED


    public Topic() {
    }

    public Topic(long id, String name, String givenName, String info, long parentId) {
        this.id = id;
        this.name = name;
        this.givenName = givenName;
        this.info = info;
        this.parentId = parentId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getParentId() {
        return this.parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Topic id(long id) {
        setId(id);
        return this;
    }

    public Topic name(String name) {
        setName(name);
        return this;
    }

    public Topic givenName(String givenName) {
        setGivenName(givenName);
        return this;
    }

    public Topic info(String info) {
        setInfo(info);
        return this;
    }

    public Topic parentId(long parentId) {
        setParentId(parentId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) o;
        return id == topic.id && Objects.equals(name, topic.name) && Objects.equals(givenName, topic.givenName) && Objects.equals(info, topic.info) && parentId == topic.parentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, givenName, info, parentId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", givenName='" + getGivenName() + "'" +
            ", info='" + getInfo() + "'" +
            ", parentId='" + getParentId() + "'" +
            "}";
    }
    


}


    
   

