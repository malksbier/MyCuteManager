package de.springwegarche.MyCuteManager.Models.DAO;
import java.util.Objects;

public class TopicState {
    long id;
    String state;


    public TopicState() {
    }

    public TopicState(long id, String state) {
        this.id = id;
        this.state = state;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TopicState id(long id) {
        setId(id);
        return this;
    }

    public TopicState state(String state) {
        setState(state);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TopicState)) {
            return false;
        }
        TopicState topicState = (TopicState) o;
        return id == topicState.id && Objects.equals(state, topicState.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
    
}
