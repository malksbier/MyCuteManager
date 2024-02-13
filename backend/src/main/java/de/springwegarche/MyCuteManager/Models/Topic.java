package de.springwegarche.MyCuteManager.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.micrometer.common.lang.Nullable;

@Entity
@Table(name = "TOPICS")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "given_name")
    private String givenName;
    @Column(name = "info")
    private String info;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Topic parent;

    @Column(name = "children")
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topic> children = new ArrayList<>();



    public Topic(String name, String givenName, Topic parent) {
        this.name = name;
        this.givenName = givenName;
        this.parent = parent;
    }

    public static Topic createTopicForNormalizing(String name, Topic parent, String info) {
        Topic t = new Topic();
        t.setName(name);
        t.setParent(parent);
        t.setInfo(info);
        return t;
    }
    // GENERATED

    public Topic() {
    }

    public Topic(long id, String name, String givenName, String info, Topic parent, List<Topic> children) {
        this.id = id;
        this.name = name;
        this.givenName = givenName;
        this.info = info;
        this.parent = parent;
        this.children = children;
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

    public Topic getParent() {
        return this.parent;
    }

    public void setParent(Topic parent) {
        this.parent = parent;
    }

    public List<Topic> getChildren() {
        return this.children;
    }

    public void setChildren(List<Topic> children) {
        this.children = children;
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

    public Topic parent(Topic parent) {
        setParent(parent);
        return this;
    }

    public Topic children(List<Topic> children) {
        setChildren(children);
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
        return id == topic.id && Objects.equals(name, topic.name) && Objects.equals(givenName, topic.givenName) && Objects.equals(info, topic.info) && Objects.equals(parent, topic.parent) && Objects.equals(children, topic.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, givenName, info, parent, children);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", givenName='" + getGivenName() + "'" +
            ", info='" + getInfo() + "'" +
            ", parent='" + getParent() + "'" +
            ", children='" + getChildren() + "'" +
            "}";
    }


}


    
   

