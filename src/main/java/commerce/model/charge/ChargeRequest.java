package commerce.model.charge;

import com.fasterxml.jackson.annotation.JsonProperty;
import commerce.model.pricing.PricingEntry;

import java.util.HashMap;
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

    public static Builder builder() {
        return new Builder();
    }

    private ChargeRequest(String name, String description, String pricingType, PricingEntry localPrice, Map<String, Object> metadata, String redirectUrl, String cancelUrl) {
        this.name = name;
        this.description = description;
        this.pricingType = pricingType;
        this.localPrice = localPrice;
        this.metadata = metadata;
        this.redirectUrl = redirectUrl;
        this.cancelUrl = cancelUrl;
    }

    public static class Builder {

        private String name;

        private String description;

        private String pricingType;

        private PricingEntry localPrice;

        private Map<String, Object> metadata;

        private String redirectUrl;

        private String cancelUrl;

        public ChargeRequest build() {
            return new ChargeRequest(name, description, pricingType, localPrice, metadata, redirectUrl, cancelUrl);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPricingType(String pricingType) {
            this.pricingType = pricingType;
            return this;
        }

        public Builder setCurrency(String currency) {
            if (this.localPrice == null) {
                this.localPrice = new PricingEntry();
            }
            this.localPrice.setCurrency(currency.toUpperCase());
            return this;
        }

        public Builder setAmount(double amount) {
            if (this.localPrice == null) {
                this.localPrice = new PricingEntry();
            }
            this.localPrice.setAmount(String.valueOf(amount));
            return this;
        }

        public Builder putMetadata(String key, Object value) {
            if (this.metadata == null) {
                this.metadata = new HashMap<>();
            }
            this.metadata.put(key, value);
            return this;
        }

        public Builder setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        public Builder setCancelUrl(String cancelUrl) {
            this.cancelUrl = cancelUrl;
            return this;
        }

    }
}
