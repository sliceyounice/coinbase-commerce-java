package commerce.api.operations;

public interface UpdateOperation<T, U> {

    U update(T updateObject);
}
