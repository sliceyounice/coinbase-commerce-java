package commerce.api.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import commerce.ApiClient;
import commerce.api.operations.CreateOperation;
import commerce.api.operations.RetrieveOperation;
import commerce.model.charge.Charge;
import commerce.model.charge.ChargeRequest;

import java.util.HashMap;
import java.util.List;

public class Charges extends ApiResource<Charge> implements CreateOperation<ChargeRequest, Charge>, RetrieveOperation<Charge> {

    @Override
    protected String getResourcePath() {
        return "charges";
    }

    @Override
    protected Class<Charge> getResourceClass() {
        return Charge.class;
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
}
