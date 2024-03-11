package de.springwegarche.MyCuteManager.Models.DAO;
import java.util.Objects;

public class DeleteRequest {
    private long id;


    public DeleteRequest() {
    }

    public DeleteRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DeleteRequest id(long id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DeleteRequest)) {
            return false;
        }
        DeleteRequest deleteRequest = (DeleteRequest) o;
        return id == deleteRequest.id;
    }
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            "}";
    }
    
}
