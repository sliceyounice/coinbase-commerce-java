package commerce.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class WebhookEventPayload {

    String id;

    @JsonProperty("scheduled_for")
    Date scheduledFor;

    @JsonProperty("attempt_number")
    Integer attemptNumber;

    Event event;

    public String getId() {
        return id;
    }

    public Date getScheduledFor() {
        return scheduledFor;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public Event getEvent() {
        return event;
    }
}
