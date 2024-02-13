package de.springwegarche.MyCuteManager.Models;
import java.util.Objects;

public class SimpleTopic {
    private String topic;
    private String message;

    // GENERATED
    public SimpleTopic() {
    }

    public SimpleTopic(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SimpleTopic)) {
            return false;
        }
        SimpleTopic simpleTopic = (SimpleTopic) o;
        return Objects.equals(topic, simpleTopic.topic) && Objects.equals(message, simpleTopic.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, message);
    }

    @Override
    public String toString() {
        return "{" +
            " topic='" + getTopic() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }
    
}
