package de.springwegarche.MyCuteManager.Models.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import de.springwegarche.MyCuteManager.Models.Topic;

public class WebTopic {
    private long id;
    private long parentId;
    private String name;
    private String givenName;
    private String info;
    private List<WebTopic> children;


    public static WebTopic fromTopic (Topic t) {
        List<WebTopic> children = new ArrayList<WebTopic>();
        return new WebTopic(t.getId(), t.getParentId(),t.getName(),t.getGivenName(),t.getInfo(), children);
    }
    public void addChild(WebTopic t) {
        this.children.add(t);
    }

    public void setInfo(String info) {
        if(info.toLowerCase().contains("on/off")) {
            this.info = "relais";
            return;
        } else if(info.toLowerCase().contains("dir")) {
            this.info = "";
            return;
        }
        
        this.info = info;
    }

    public WebTopic(long id, long parentId, String name, String givenName, String info, List<WebTopic> children) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.givenName = givenName;
        setInfo(info);
        this.children = children;
    }

    // generated


    public WebTopic() {
    }

    

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return this.parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
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

    

    public List<WebTopic> getChildren() {
        return this.children;
    }

    public void setChildren(List<WebTopic> children) {
        this.children = children;
    }

    public WebTopic id(long id) {
        setId(id);
        return this;
    }

    public WebTopic parentId(long parentId) {
        setParentId(parentId);
        return this;
    }

    public WebTopic name(String name) {
        setName(name);
        return this;
    }

    public WebTopic givenName(String givenName) {
        setGivenName(givenName);
        return this;
    }

    public WebTopic info(String info) {
        setInfo(info);
        return this;
    }

    public WebTopic children(List<WebTopic> children) {
        setChildren(children);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WebTopic)) {
            return false;
        }
        WebTopic webTopic = (WebTopic) o;
        return id == webTopic.id && parentId == webTopic.parentId && Objects.equals(name, webTopic.name) && Objects.equals(givenName, webTopic.givenName) && Objects.equals(info, webTopic.info) && Objects.equals(children, webTopic.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name, givenName, info, children);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", parentId='" + getParentId() + "'" +
            ", name='" + getName() + "'" +
            ", givenName='" + getGivenName() + "'" +
            ", info='" + getInfo() + "'" +
            ", children='" + getChildren() + "'" +
            "}";
    }



    
}
