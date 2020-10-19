package commerce.api.operations;

import commerce.model.list.ListResponse;
import commerce.model.list.pagination.Pagination;

public interface ListOperation<T> {

    ListResponse<T> list(int limit);

    ListResponse<T> getNext(Pagination pagination);
}
