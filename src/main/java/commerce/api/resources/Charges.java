package commerce.api.resources;

import commerce.ApiClient;
import commerce.api.operations.CreateOperation;
import commerce.model.charge.Charge;
import commerce.model.charge.ChargeRequest;

import java.util.HashMap;

public class Charges extends ApiResource implements CreateOperation<ChargeRequest, Charge> {

    @Override
    protected String getResourcePath() {
        return "charges";
    }

    public Charges(ApiClient apiClient) {
        super(apiClient);
    }

    @Override
    public Charge create(ChargeRequest createObject) {
        return this.apiClient.post(getResourcePath(), createObject, new HashMap<>(), Charge.class);
    }
}
