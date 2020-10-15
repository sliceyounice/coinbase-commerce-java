package commerce.api.operations;

public interface CreateOperation<T, U> {

    U create(T createObject);
}
