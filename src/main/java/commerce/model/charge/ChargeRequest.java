package commerce.model.charge;

import com.fasterxml.jackson.annotation.JsonProperty;
import commerce.model.pricing.PricingEntry;

import java.util.Map;

public class ChargeRequest {

    private String name;

    private String description;

    @JsonProperty("pricing_type")
    private String pricingType;

    @JsonProperty("local_price")
    private PricingEntry localPrice;

    private Map<String, Object> metadata;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("cancel_url")
    private String cancelUrl;

    public ChargeRequest(String name, String description) {
        this.name = name;
        this.description = description;
        this.pricingType = "no_price";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPricingType() {
        return pricingType;
    }

    public PricingEntry getLocalPrice() {
        return localPrice;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public void setLocalPrice(PricingEntry localPrice) {
        this.localPrice = localPrice;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }
}
