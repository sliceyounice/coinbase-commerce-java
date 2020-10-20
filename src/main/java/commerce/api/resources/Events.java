package commerce.api.resources;

import commerce.ApiClient;
import commerce.api.operations.ListOperation;
import commerce.model.event.Event;
import commerce.model.list.ListResponse;
import commerce.model.list.pagination.Pagination;
import kong.unirest.GenericType;

public class Events extends ApiResource<Event> implements ListOperation<Event> {

    public Events(ApiClient apiClient) {
        super(apiClient);
    }

    @Override
    public ListResponse<Event> list(int limit) {
        return super.listResource(limit);
    }

    @Override
    public ListResponse<Event> getNext(Pagination pagination) {
        return super.getNextPage(pagination);
    }

    @Override
    protected String getResourcePath() {
        return "events";
    }

    @Override
    protected Class<Event> getResourceClass() {
        return Event.class;
    }

    @Override
    protected GenericType<ListResponse<Event>> getGenericType() {
        return new GenericType<ListResponse<Event>>() {};
    }
}
