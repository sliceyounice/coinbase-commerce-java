package commerce.model.list.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pagination {

    private String order;

    @JsonProperty("starting_after")
    private String startingAfter;

    @JsonProperty("ending_before")
    private String endingBefore;

    private int total;

    private int yielded;

    private int limit;

    @JsonProperty("previous_uri")
    private String previousUri;

    @JsonProperty("next_uri")
    private String nextUri;

    @JsonProperty("cursor_range")
    private List<String> cursorRange;

    public String getOrder() {
        return order;
    }

    public String getStartingAfter() {
        return startingAfter;
    }

    public String getEndingBefore() {
        return endingBefore;
    }

    public int getTotal() {
        return total;
    }

    public int getYielded() {
        return yielded;
    }

    public int getLimit() {
        return limit;
    }

    public String getPreviousUri() {
        return previousUri;
    }

    public String getNextUri() {
        return nextUri;
    }

    public List<String> getCursorRange() {
        return cursorRange;
    }
}
