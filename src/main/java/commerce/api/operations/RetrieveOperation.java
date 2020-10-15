package commerce.api.operations;

public interface RetrieveOperation<T> {

    T retrieve(String entityId);
}
