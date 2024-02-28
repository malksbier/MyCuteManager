package de.springwegarche.MyCuteManager.Models.DAO;
import java.util.Objects;

public class TopicNewName {
    long id;
    String newName;

    // generated


    public TopicNewName() {
    }

    public TopicNewName(long id, String newName) {
        this.id = id;
        this.newName = newName;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNewName() {
        return this.newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public TopicNewName id(long id) {
        setId(id);
        return this;
    }

    public TopicNewName newName(String newName) {
        setNewName(newName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TopicNewName)) {
            return false;
        }
        TopicNewName topicNewName = (TopicNewName) o;
        return id == topicNewName.id && Objects.equals(newName, topicNewName.newName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", newName='" + getNewName() + "'" +
            "}";
    }
    
}
