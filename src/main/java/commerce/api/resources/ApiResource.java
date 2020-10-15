package commerce.api.resources;

import commerce.ApiClient;

public abstract class ApiResource {

    protected ApiClient apiClient;

    public ApiResource(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected abstract String getResourcePath();



}
