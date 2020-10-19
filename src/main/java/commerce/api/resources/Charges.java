package commerce.api.resources;

import commerce.ApiClient;
import commerce.api.operations.CreateOperation;
import commerce.api.operations.ListOperation;
import commerce.api.operations.RetrieveOperation;
import commerce.model.list.ListResponse;
import commerce.model.charge.Charge;
import commerce.model.charge.ChargeRequest;
import commerce.model.list.pagination.Pagination;
import kong.unirest.GenericType;

public class Charges extends ApiResource<Charge> implements CreateOperation<ChargeRequest, Charge>, RetrieveOperation<Charge>,
                             ListOperation<Charge>
{

    @Override
    protected String getResourcePath() {
        return "charges";
    }

    @Override
    protected Class<Charge> getResourceClass() {
        return Charge.class;
    }

    @Override
    protected GenericType<ListResponse<Charge>> getGenericType() {
        return new GenericType<ListResponse<Charge>>() {};
    }

    public Charges(ApiClient apiClient) {
        super(apiClient);
    }

    @Override
    public Charge create(ChargeRequest createObject) {
        return super.createResource(createObject);
    }

    @Override
    public Charge retrieve(String entityId) {
        return super.retrieveResource(entityId);
    }

    @Override
    public ListResponse<Charge> list(int limit) {
        return super.listResource(limit);
    }

    @Override
    public ListResponse<Charge> getNext(Pagination pagination) {
        return super.getNextPage(pagination);
    }
}
