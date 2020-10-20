package commerce.model.list;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import commerce.model.list.pagination.Pagination;
import commerce.util.deserializers.CustomListDeserializer;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

@JsonDeserialize(using = CustomListDeserializer.class)
public class ListResponse<T> extends AbstractList<T> {

    private List<T> data;

    private Pagination pagination;

    public ListResponse(List<T> data) {
        this.data = data;
    }

    public ListResponse(List<T> data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public ListResponse() {
    }

    public boolean hasNext() {
        return pagination.getYielded() == pagination.getLimit();
    }

    public Pagination getPagination() {
        return pagination;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean add(T t) {
        return data.add(t);
    }

    @Override
    public T get(int index) {
        return data.get(index);
    }
}
