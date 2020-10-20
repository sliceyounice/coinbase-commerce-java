package commerce.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import commerce.model.charge.Charge;

import java.util.Date;

public class Event {

    String id;

    String resource;

    String type;

    String apiVersion;

    @JsonProperty("created_at")
    Date createdAt;

    Charge data;

    public String getId() {
        return id;
    }

    public String getResource() {
        return resource;
    }

    public String getType() {
        return type;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Charge getData() {
        return data;
    }
}
