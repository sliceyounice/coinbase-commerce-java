package commerce.api.resources;

import commerce.ApiClient;
import commerce.model.list.ListResponse;
import commerce.model.list.pagination.Pagination;
import kong.unirest.GenericType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ApiResource<T> {

    protected ApiClient apiClient;

    public ApiResource(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected abstract String getResourcePath();

    protected abstract Class<T> getResourceClass();

    protected abstract GenericType<ListResponse<T>> getGenericType();

    protected T createResource(Object createObject) {
        return apiClient.post(getResourcePath(), createObject, new HashMap<>(), getResourceClass());
    }

    protected T retrieveResource(String entityId) {
        return apiClient
                .get(String.join("/", getResourcePath(), entityId), new HashMap<>(), new HashMap<>(), getResourceClass());
    }

    protected ListResponse<T> listResource(int limit) {
        Map<String, Object> query = new HashMap<>();
        query.put("limit", limit);
        return apiClient.get(getResourcePath(), query, Collections.emptyMap(), getGenericType());
    }

    protected ListResponse<T> getNextPage(Pagination pagination) {
        Map<String, Object> query = new HashMap<>();
        query.put("limit", pagination.getLimit());
        query.put("starting_after", pagination.getCursorRange().get(1));
        return apiClient.get(getResourcePath(), query, Collections.emptyMap(), getGenericType());
    }



}
