package commerce.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class CoinbaseError {

    private String type;

    private String message;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
