package commerce.model.charge;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import commerce.model.pricing.PricingEntry;

import java.util.Date;
import java.util.List;
import java.util.Map;

@JsonRootName("data")
public class Charge {

    private String id;

    private String resource;

    private String code;

    private String name;

    private String description;

    @JsonProperty("hosted_url")
    private String hostedUrl;

    private Date createdAt;

    private Date expiresAt;

    private Date confirmedAt;

    private Object checkout;

    private List<Timeline> timeline;

    private Map<String, Object> metadata;

    @JsonProperty("pricing_type")
    private String pricingType;

    private Pricing pricing;

    private PaymentThreshold payment_threshold;

    private PricingEntry applied_threshold;

    private String applied_threshold_type;

    private List<Payment> payments;

    private Addresses addresses;

    public String getId() {
        return id;
    }

    public String getResource() {
        return resource;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHostedUrl() {
        return hostedUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public Object getCheckout() {
        return checkout;
    }

    public List<Timeline> getTimeline() {
        return timeline;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getPricingType() {
        return pricingType;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public PaymentThreshold getPayment_threshold() {
        return payment_threshold;
    }

    public PricingEntry getApplied_threshold() {
        return applied_threshold;
    }

    public String getApplied_threshold_type() {
        return applied_threshold_type;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    private static class Timeline {
        public Date time;
        public String status;
        public String context;

        public Date getTime() {
            return time;
        }

        public String getStatus() {
            return status;
        }

        public String getContext() {
            return context;
        }
    }

    private static class Pricing {
        private PricingEntry local;
        private PricingEntry bitcoin;
        private PricingEntry ethereum;

        public PricingEntry getLocal() {
            return local;
        }

        public PricingEntry getBitcoin() {
            return bitcoin;
        }

        public PricingEntry getEthereum() {
            return ethereum;
        }
    }

    private static class PaymentThreshold {
        private PricingEntry overpayment_absolute_threshold;
        private String overpayment_relative_threshold;
        private PricingEntry underpayment_absolute_threshold;
        private String underpayment_relative_threshold;

        public PricingEntry getOverpayment_absolute_threshold() {
            return overpayment_absolute_threshold;
        }

        public String getOverpayment_relative_threshold() {
            return overpayment_relative_threshold;
        }

        public PricingEntry getUnderpayment_absolute_threshold() {
            return underpayment_absolute_threshold;
        }

        public String getUnderpayment_relative_threshold() {
            return underpayment_relative_threshold;
        }
    }

    private static class Value {
        private PricingEntry local;
        private PricingEntry crypto;

        public PricingEntry getLocal() {
            return local;
        }

        public PricingEntry getCrypto() {
            return crypto;
        }
    }

    private static class Block {
        private int height;
        private String hash;
        private int confirmations_accumulated;
        private int confirmations_required;

        public int getHeight() {
            return height;
        }

        public String getHash() {
            return hash;
        }

        public int getConfirmations_accumulated() {
            return confirmations_accumulated;
        }

        public int getConfirmations_required() {
            return confirmations_required;
        }
    }

    private static class Payment {
        private String network;
        private String transaction_id;
        private String status;
        private Value value;
        private Block block;

        public String getNetwork() {
            return network;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public String getStatus() {
            return status;
        }

        public Value getValue() {
            return value;
        }

        public Block getBlock() {
            return block;
        }
    }

    private static class Addresses {
        private String bitcoin;
        private String ethereum;

        public String getBitcoin() {
            return bitcoin;
        }

        public String getEthereum() {
            return ethereum;
        }
    }

}
