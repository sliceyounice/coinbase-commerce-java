package commerce.api.resources;

import commerce.ApiClient;

import java.util.HashMap;
import java.util.List;

public abstract class ApiResource<T> {

    protected ApiClient apiClient;

    public ApiResource(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected abstract String getResourcePath();

    protected abstract Class<T> getResourceClass();

    protected T createResource(Object createObject) {
        return apiClient.post(getResourcePath(), createObject, new HashMap<>(), getResourceClass());
    }

    protected T retrieveResource(String entityId) {
        return apiClient
                .get(String.join("/", getResourcePath(), entityId), new HashMap<>(), new HashMap<>(), getResourceClass());
    }



}
