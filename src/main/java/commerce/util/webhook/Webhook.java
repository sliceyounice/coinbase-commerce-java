package commerce.util.webhook;

import commerce.exception.InvalidWebhookPayloadException;
import commerce.exception.SignatureVerificationException;
import commerce.model.event.Event;
import commerce.model.event.WebhookEventPayload;
import commerce.util.JsonMapper;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Webhook {

    private static final JsonMapper mapper = new JsonMapper();

    private Webhook() {}

    public static Event constructEvent(String payload, String secret, String signatureHeader) {
        WebhookEventPayload mappedPayload = mapper.readValue(payload, WebhookEventPayload.class);
        if (mappedPayload == null || mappedPayload.getEvent() == null) {
            throw new InvalidWebhookPayloadException("Invalid payload provided. No JSON object could be read");
        }
        verify(payload, secret, signatureHeader);
        return mappedPayload.getEvent();
    }

    private static void verify(String payload, String secret, String signatureHeader) {
        try {
            Mac hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            hmac.init(secretKey);
            byte[] result = hmac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            String hash = Hex.encodeHexString(result);
            if (!StringUtils.equals(hash, signatureHeader)) {
                throw new SignatureVerificationException("Invalid payload provided");
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
