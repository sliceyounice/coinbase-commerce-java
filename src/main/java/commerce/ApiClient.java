package commerce;

import commerce.api.resources.Charges;
import commerce.util.JsonMapper;
import kong.unirest.*;

import java.util.Map;

public class ApiClient {

    private final String apiKey;

    private final String apiVersion;

    private static final String BASE_URL = "https://api.commerce.coinbase.com";

    private final UnirestInstance unirest;

    private Charges charges;

    public ApiClient(String apiKey) {
        this(apiKey, "2018-03-22");
    }

    public ApiClient(String apiKey, String apiVersion) {
        this.apiKey = apiKey;
        this.apiVersion = apiVersion;
        this.unirest = Unirest.spawnInstance();
        unirest.config().setDefaultHeader("X-CC-Api-Key", apiKey)
                .setDefaultHeader("X-CC-Version", apiVersion)
                .setDefaultHeader("Content-Type", "application/json")
                .verifySsl(true).followRedirects(true).setObjectMapper(new JsonMapper());
    }

    public Charges charges() {
        if (this.charges == null) {
            this.charges = new Charges(this);
        }
        return this.charges;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    private <T> T makeRequest(HttpRequest<?> request, Class<T> entityClass) {
        HttpResponse<T> response = request.asObjectAsync(entityClass).join();
        return response.getBody();
    }

    private <T> T makeRequest(HttpRequest<?> request, GenericType<T> genericType) {
        HttpResponse<T> response = request.asObjectAsync(genericType).join();
        return response.getBody();
    }

    public <T> T get(String path, Map<String, Object> queryParams, Map<String, String> headers, Class<T> entityClass) {
        return makeRequest(unirest.get(String.join("/", BASE_URL, path))
                .queryString(queryParams).headers(headers), entityClass);
    }

    public <T> T get(String path, Map<String, Object> queryParams, Map<String, String> headers, GenericType<T> genericType) {
        return makeRequest(unirest.get(String.join("/", BASE_URL, path))
                .queryString(queryParams).headers(headers), genericType);
    }

    public <T> T post(String path, Object body, Map<String, String> headers, Class<T> entityClass) {
        return makeRequest(unirest.post(String.join("/", BASE_URL, path))
                .body(body).headers(headers), entityClass);
    }

    public <T> T put(String path, Object body, Map<String, String> headers, Class<T> entityClass) {
        return makeRequest(unirest.put(String.join("/", BASE_URL, path)).
                body(body).headers(headers), entityClass);
    }

    public <T> T delete(String path, String entityId, Map<String, String> headers, Class<T> entityClass) {
        return makeRequest(unirest.get(String.join("/", BASE_URL, path, entityId))
                .headers(headers), entityClass);
    }

    @Override
    protected void finalize() throws Throwable {
        unirest.close();
        super.finalize();
    }
}
